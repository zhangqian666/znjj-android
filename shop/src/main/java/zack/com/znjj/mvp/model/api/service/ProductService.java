package zack.com.znjj.mvp.model.api.service;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import zack.com.znjj.mvp.model.entity.Product;
import zack.com.znjj.mvp.model.entity.base.BasePageList;
import zack.com.znjj.mvp.model.entity.base.BaseResponse;

/**
 * Created by Administrator on 2018/2/2.
 */

public interface ProductService {

    @FormUrlEncoded
    @POST("/product/list/")
    Observable<BaseResponse<BasePageList<Product>>> getProductList(
            @Field("keyword") String keyword,
            @Field("categoryId") Integer categoryId
    );
}
