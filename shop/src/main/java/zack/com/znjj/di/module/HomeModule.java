package zack.com.znjj.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
import zack.com.znjj.mvp.contract.HomeContract;
import zack.com.znjj.mvp.model.HomeModel;

/**
 * Created by Administrator on 2018/2/1.
 */

@Module
public class HomeModule {

    private HomeContract.View view;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HomeContract.View provideHomeView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HomeContract.Model provideHomeModel(HomeModel model) {
        return model;
    }
}
