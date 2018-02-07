package zack.com.znjj.mvp.ui.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.di.component.AppComponent;

import me.yokeyword.fragmentation.ISupportFragment;
import zack.com.znjj.R;
import zack.com.znjj.app.base.BaseSupportFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseSupportFragment {

    public static ISupportFragment newInstance() {
        return new ShopFragment();
    }

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }


}
