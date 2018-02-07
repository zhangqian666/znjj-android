package zack.com.znjj.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;
import timber.log.Timber;
import zack.com.znjj.R;
import zack.com.znjj.app.base.BaseSupportActivity;
import zack.com.znjj.app.utils.BottomNavigationViewHelper;
import zack.com.znjj.di.component.DaggerMainComponent;
import zack.com.znjj.di.module.MainModule;
import zack.com.znjj.mvp.contract.MainContract;
import zack.com.znjj.mvp.presenter.MainPresenter;
import zack.com.znjj.mvp.ui.fragment.main.CartFragment;
import zack.com.znjj.mvp.ui.fragment.main.HomeFragment;
import zack.com.znjj.mvp.ui.fragment.main.SelfFragment;
import zack.com.znjj.mvp.ui.fragment.main.ShopFragment;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseSupportActivity<MainPresenter> implements MainContract.View, BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.frame_content)
    FrameLayout frameContent;
    @BindView(R.id.navigation_view)
    BottomNavigationView navigationView;

    private ISupportFragment[] mFragments = new ISupportFragment[4];

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initFragmentation();
        BottomNavigationViewHelper.disableShiftMode(navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
    }


    private void initFragmentation() {
        ISupportFragment homeFragment = findFragment(HomeFragment.class);
        if (homeFragment == null) {
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = ShopFragment.newInstance();
            mFragments[2] = CartFragment.newInstance();
            mFragments[3] = SelfFragment.newInstance();
            loadMultipleRootFragment(R.id.frame_content, 0, mFragments);
        } else {
            mFragments[0] = findFragment(HomeFragment.class);
            mFragments[1] = findFragment(ShopFragment.class);
            mFragments[2] = findFragment(CartFragment.class);
            mFragments[3] = findFragment(SelfFragment.class);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Timber.e("home");
                showHideFragment(mFragments[0]);
                return true;
            case R.id.see:
                Timber.e("self");
                showHideFragment(mFragments[1]);
                return true;
            case R.id.shop:
                Timber.e("self");
                showHideFragment(mFragments[2]);
                return true;
            case R.id.self:
                Timber.e("self");
                showHideFragment(mFragments[3]);
                return true;
        }
        return false;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_float)
    public void onViewClicked() {
        ArmsUtils.startActivity(this, CreateProductActivity.class);
    }
}
