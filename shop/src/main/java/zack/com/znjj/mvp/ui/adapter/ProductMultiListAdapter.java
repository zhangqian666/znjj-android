package zack.com.znjj.mvp.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zack.com.znjj.R;
import zack.com.znjj.mvp.model.entity.Product;

/**
 * Created by Administrator on 2018/2/2.
 */

public class ProductMultiListAdapter extends BaseMultiItemQuickAdapter<Product, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ProductMultiListAdapter(List<Product> data) {
        super(data);
        addItemType(0, R.layout.item_home_product_list);
    }


    @Override
    protected void convert(BaseViewHolder helper, Product item) {
        switch (item.getItemType()) {
            case 0:
                helper.setText(R.id.tv_title, item.getName())
                        .setText(R.id.tv_subtitle, item.getSubtitle())
                        .setText(R.id.tv_prices, item.getPrice() + "");
                Glide.with(mContext)
                        .load(item.getImageHost() + item.getMainImage())
                        .into((ImageView) helper.getView(R.id.iv_content));
                break;
        }
    }
}
