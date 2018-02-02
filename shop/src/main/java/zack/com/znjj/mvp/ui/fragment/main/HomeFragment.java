package zack.com.znjj.mvp.ui.fragment.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ISupportFragment;
import zack.com.znjj.R;
import zack.com.znjj.app.base.BaseSupportFragment;
import zack.com.znjj.di.component.DaggerHomeComponent;
import zack.com.znjj.di.module.HomeModule;
import zack.com.znjj.mvp.contract.HomeContract;
import zack.com.znjj.mvp.model.entity.Product;
import zack.com.znjj.mvp.presenter.HomePresenter;
import zack.com.znjj.mvp.ui.adapter.ProductMultiListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseSupportFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    private List<Product> productList = new ArrayList<>();
    private ProductMultiListAdapter productMultiListAdapter;

    public static ISupportFragment newInstance() {
        return new HomeFragment();
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerHomeComponent
                .builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getProductList("", null);
            }
        });

        recycleView.setLayoutManager(new GridLayoutManager(_mActivity, 2));
        productMultiListAdapter = new ProductMultiListAdapter(productList);
        recycleView.setAdapter(productMultiListAdapter);
        mPresenter.getProductList("", null);
    }

    @Override
    public void setData(Object data) {

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

    }

    @Override
    public void killMyself() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void refreshList(List<Product> list) {
        this.productList.clear();
        productList.addAll(list);
        swipeRefresh.setRefreshing(false);
        productMultiListAdapter.notifyDataSetChanged();
    }
}
