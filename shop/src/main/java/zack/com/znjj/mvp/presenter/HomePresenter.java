package zack.com.znjj.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import zack.com.znjj.mvp.contract.HomeContract;
import zack.com.znjj.mvp.model.entity.Product;
import zack.com.znjj.mvp.model.entity.base.BasePageList;
import zack.com.znjj.mvp.model.entity.base.BaseResponse;

/**
 * Created by Administrator on 2018/2/1.
 */

@FragmentScope
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);

        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
    }

    public void getProductList(String keyword, Integer categoryId) {
        mModel.getProductList(keyword, categoryId)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mRootView.showLoading();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        mRootView.hideLoading();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<BaseResponse<BasePageList<Product>>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<BasePageList<Product>> basePageListBaseResponse) {
                        if (basePageListBaseResponse.isSuccess()) {
                            mRootView.refreshList(basePageListBaseResponse.getData().getList());
                        } else {
                            mRootView.showMessage(basePageListBaseResponse.getMsg());
                        }
                    }
                });
    }
}
