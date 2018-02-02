package zack.com.znjj.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import zack.com.znjj.di.module.LoginModule;
import zack.com.znjj.mvp.ui.activity.LoginActivity;

/**
 * Created by Administrator on 2018/1/31.
 */
@ActivityScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
