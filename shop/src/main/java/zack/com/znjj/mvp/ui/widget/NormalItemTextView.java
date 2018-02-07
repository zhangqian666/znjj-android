package zack.com.znjj.mvp.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/2/7.
 */

public class NormalItemTextView extends LinearLayout {

    public NormalItemTextView(Context context) {
        this(context, null);

    }

    public NormalItemTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NormalItemTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        ImageView imageView = new ImageView(context);
        LinearLayoutCompat.LayoutParams imageParams = new LinearLayoutCompat.LayoutParams(100, 100);
        imageParams.gravity = Gravity.CENTER_VERTICAL;
        imageParams.setMargins(8, 0, 0, 0);
        addView(imageView, imageParams);


        LinearLayoutCompat.LayoutParams textParams = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textParams.gravity = Gravity.CENTER_VERTICAL;
        textParams.setMargins(8, 0, 0, 0);
        textParams.weight = 1;
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setText("NORMAL_ITEM");
        addView(imageView, textParams);

        LinearLayoutCompat.LayoutParams optionParams = new LinearLayoutCompat.LayoutParams(100, 100);
        optionParams.gravity = Gravity.CENTER_VERTICAL;
        optionParams.setMargins(0, 0, 8, 0);
        ImageView optionImage = new ImageView(context);

        addView(optionImage, optionParams);


    }
}
