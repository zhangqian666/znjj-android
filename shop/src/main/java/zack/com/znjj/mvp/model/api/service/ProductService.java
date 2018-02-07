package zack.com.znjj.mvp.model.api.service;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import zack.com.znjj.mvp.model.entity.ImgFile;
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


    @Multipart
    @POST("/manage/product/upload/")
    Observable<BaseResponse<ImgFile>> upLoadImg(
            @Part MultipartBody.Part upload_file,
            @Header("token") String token
    );


}
