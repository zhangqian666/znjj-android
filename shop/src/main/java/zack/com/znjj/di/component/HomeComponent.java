package zack.com.znjj.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;
import zack.com.znjj.di.module.HomeModule;
import zack.com.znjj.mvp.ui.fragment.main.HomeFragment;

/**
 * Created by Administrator on 2018/2/1.
 */

@FragmentScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeFragment homeFragment);
}
