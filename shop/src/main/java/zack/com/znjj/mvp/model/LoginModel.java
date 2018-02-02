package zack.com.znjj.mvp.model;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import zack.com.znjj.mvp.contract.LoginContract;
import zack.com.znjj.mvp.model.api.service.UserService;
import zack.com.znjj.mvp.model.entity.base.BaseResponse;
import zack.com.znjj.mvp.model.entity.User;


@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.Model {


    @Inject
    public LoginModel(IRepositoryManager repositoryManager, Application application) {
        super(repositoryManager);
    }


    @Override
    public Observable<BaseResponse<User>> login(String username, String password) {
        return mRepositoryManager.obtainRetrofitService(UserService.class).login(username, password);
    }
}
