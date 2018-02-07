package zack.com.znjj.mvp.presenter;

import android.app.Activity;
import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.PermissionUtil;
import com.jess.arms.utils.RxLifecycleUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import zack.com.znjj.mvp.contract.CreateProductContract;
import zack.com.znjj.mvp.contract.LoginContract;
import zack.com.znjj.mvp.model.entity.ImgFile;
import zack.com.znjj.mvp.model.entity.base.BaseResponse;

/**
 * Created by Administrator on 2018/2/6.
 */

@ActivityScope
public class CreateProductPresenter extends BasePresenter<CreateProductContract.Model, CreateProductContract.View> {

    private LoginContract.Model loginModel;
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;

    @Inject
    public CreateProductPresenter(LoginContract.Model loginModel
            , CreateProductContract.Model model, CreateProductContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);

        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
        this.loginModel = loginModel;
    }

    public void upLoadImg(String url) {
        File file = new File(url);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("upload_file", file.getName(), requestBody);

        mModel.upLoadImg(part)
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
                .subscribe(new ErrorHandleSubscriber<BaseResponse<ImgFile>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<ImgFile> imgFileBaseResponse) {
                        if (imgFileBaseResponse.isSuccess()) {
                            mRootView.upLoadImgSuccess(imgFileBaseResponse.getData().getUrl());
                        } else {
                            mRootView.showMessage(imgFileBaseResponse.getMsg());
                        }
                    }
                });
    }

    public void requestPermission(Activity activity) {
        PermissionUtil.externalStorage(new PermissionUtil.RequestPermission() {
            @Override
            public void onRequestPermissionSuccess() {
                mRootView.startUpLoadImg();
            }

            @Override
            public void onRequestPermissionFailure(List<String> permissions) {
                mRootView.showMessage("请求权限失败");
            }

            @Override
            public void onRequestPermissionFailureWithAskNeverAgain(List<String> permissions) {
                mRootView.showMessage("需要去设置打开内存权限");
            }
        }, new RxPermissions(activity), mErrorHandler);
    }
}
