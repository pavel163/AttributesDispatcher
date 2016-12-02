package com.ebr163.android.attributesdispatcher;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.ebr163.attributesdispatcher.Attribute;
import com.ebr163.attributesdispatcher.CustomView;
import com.ebr163.attributesdispatcher.attr.ColorAttr;
import com.ebr163.attributesdispatcher.attr.StringAttr;

/**
 * Created by mac1 on 24.11.16.
 */

@CustomView
public class MyCustomView extends EditText {

    @ColorAttr("custom_color")
    protected int color;
    @StringAttr("custom_text")
    protected String text;

    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        MyCustomViewAttribute.init(this, attrs);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        MyCustomViewAttribute.init(this, attrs);
    }

    @Attribute
    protected void setCustomAttr(@ColorAttr("custom_color") int color) {
        this.setTextColor(color);
    }
}
