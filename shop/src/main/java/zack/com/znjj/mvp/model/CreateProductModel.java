package zack.com.znjj.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import zack.com.znjj.app.GlobalConfiguration;
import zack.com.znjj.mvp.contract.CreateProductContract;
import zack.com.znjj.mvp.model.api.service.ProductService;
import zack.com.znjj.mvp.model.entity.ImgFile;
import zack.com.znjj.mvp.model.entity.base.BaseResponse;

/**
 * Created by Administrator on 2018/2/6.
 */

@ActivityScope
public class CreateProductModel extends BaseModel implements CreateProductContract.Model {

    @Inject
    public CreateProductModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<BaseResponse<ImgFile>> upLoadImg(MultipartBody.Part part) {
        return mRepositoryManager.obtainRetrofitService(ProductService.class).upLoadImg(part, GlobalConfiguration.HEADER_TOKEN);
    }
}
