package zack.com.znjj.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import zack.com.znjj.di.module.CreateProductModule;
import zack.com.znjj.mvp.ui.activity.CreateProductActivity;

/**
 * Created by Administrator on 2018/2/6.
 */

@ActivityScope
@Component(modules = CreateProductModule.class, dependencies = AppComponent.class)
public interface CreateProductComponent {
    void inject(CreateProductActivity activity);
}
