package zack.com.znjj.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import zack.com.znjj.mvp.contract.CreateProductContract;
import zack.com.znjj.mvp.contract.LoginContract;
import zack.com.znjj.mvp.model.CreateProductModel;
import zack.com.znjj.mvp.model.LoginModel;

/**
 * Created by Administrator on 2018/2/6.
 */

@Module
public class CreateProductModule {

    private CreateProductContract.View view;

    public CreateProductModule(CreateProductContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    CreateProductContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    CreateProductContract.Model provideModel(CreateProductModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    LoginContract.Model provideLoginModel(LoginModel model) {
        return model;
    }
}
