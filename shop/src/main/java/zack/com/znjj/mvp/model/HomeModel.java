package zack.com.znjj.mvp.model;

import android.app.Application;

import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import zack.com.znjj.mvp.contract.HomeContract;
import zack.com.znjj.mvp.model.api.service.ProductService;
import zack.com.znjj.mvp.model.entity.Product;
import zack.com.znjj.mvp.model.entity.base.BasePageList;
import zack.com.znjj.mvp.model.entity.base.BaseResponse;

/**
 * Created by Administrator on 2018/2/1.
 */

@FragmentScope
public class HomeModel extends BaseModel implements HomeContract.Model {


    @Inject
    public HomeModel(IRepositoryManager repositoryManager, Application application) {
        super(repositoryManager);
    }

    public Observable<BaseResponse<BasePageList<Product>>> getProductList(String keyword, Integer categoryId) {

        return mRepositoryManager.obtainRetrofitService(ProductService.class).getProductList(keyword, categoryId);
    }
}
