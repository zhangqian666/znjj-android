package zack.com.znjj.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import zack.com.znjj.mvp.contract.LoginContract;
import zack.com.znjj.mvp.model.LoginModel;


/**
 * Created by Administrator on 2018/1/31.
 */

@Module
public class LoginModule {
    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginContract.View provideMainView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    LoginContract.Model provideMainModel(LoginModel model) {
        return model;
    }
}
