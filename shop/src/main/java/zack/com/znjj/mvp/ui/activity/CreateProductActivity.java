package zack.com.znjj.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.OnClick;
import zack.com.znjj.R;
import zack.com.znjj.app.base.BaseSupportActivity;
import zack.com.znjj.app.utils.PicChooserHelper;
import zack.com.znjj.di.component.DaggerCreateProductComponent;
import zack.com.znjj.di.module.CreateProductModule;
import zack.com.znjj.mvp.contract.CreateProductContract;
import zack.com.znjj.mvp.presenter.CreateProductPresenter;

public class CreateProductActivity extends BaseSupportActivity<CreateProductPresenter> implements CreateProductContract.View {


    @BindView(R.id.iv_content)
    ImageView ivContent;
    private PicChooserHelper mPicChooserHelper;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerCreateProductComponent.builder()
                .appComponent(appComponent)
                .createProductModule(new CreateProductModule(this))
                .build()
                .inject(this);

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_creat_product;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPicChooserHelper = new PicChooserHelper(this, PicChooserHelper.PicType.Cover);
        mPicChooserHelper.setOnChooseResultListener(new PicChooserHelper.OnChooseResultListener() {
            @Override
            public void onSuccess(String url) {
                // TODO: 2018/2/6 上传图片
                ArmsUtils.snackbarText("获取图片成功，开始上传");
                mPresenter.upLoadImg(url);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mPicChooserHelper != null) {
            mPicChooserHelper.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.btn_upload)
    public void onViewClicked() {
        mPresenter.requestPermission(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    @Override
    public void upLoadImgSuccess(String img) {
        ArmsUtils.snackbarText("上传成功");
        Glide.with(this).load(img)
                .into(ivContent);
    }

    @Override
    public void startUpLoadImg() {
        if (mPicChooserHelper != null) {
            mPicChooserHelper.showPicChooserDialog();
        }
    }

}
