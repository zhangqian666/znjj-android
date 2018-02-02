package zack.com.znjj.mvp.ui.activity;

import android.os.Bundle;

import com.jess.arms.di.component.AppComponent;

import zack.com.znjj.R;
import zack.com.znjj.app.base.BaseSupportActivity;

public class CreateProductActivity extends BaseSupportActivity {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_creat_product;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
