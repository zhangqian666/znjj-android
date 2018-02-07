package zack.com.znjj.mvp.contract;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import zack.com.znjj.mvp.model.entity.ImgFile;
import zack.com.znjj.mvp.model.entity.base.BaseResponse;

/**
 * Created by Administrator on 2018/2/6.
 */

public interface CreateProductContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void upLoadImgSuccess(String img);


        void startUpLoadImg();
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<BaseResponse<ImgFile>> upLoadImg(MultipartBody.Part part);
    }
}
