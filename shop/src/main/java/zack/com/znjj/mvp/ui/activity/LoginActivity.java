package zack.com.znjj.mvp.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;
import zack.com.znjj.R;
import zack.com.znjj.app.GlobalConfiguration;
import zack.com.znjj.app.base.BaseSupportActivity;
import zack.com.znjj.di.component.DaggerLoginComponent;
import zack.com.znjj.di.module.LoginModule;
import zack.com.znjj.mvp.contract.LoginContract;
import zack.com.znjj.mvp.model.entity.User;
import zack.com.znjj.mvp.presenter.LoginPresenter;

public class LoginActivity extends BaseSupportActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_username)
    TextInputEditText etUsername;
    @BindView(R.id.et_password)
    TextInputEditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void killMyself() {

    }


    @Override
    public void loginSuccess(User user) {
        ArmsUtils.snackbarText("登录成功");
        //登录成功后 将token赋值到 HEADER_TOKEN中 并通过interceptor添加到okhttp的header中去
        GlobalConfiguration.HEADER_TOKEN = user.getToken();
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        Timber.e("点击了登录按钮");
        mPresenter.login(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
    }
}
