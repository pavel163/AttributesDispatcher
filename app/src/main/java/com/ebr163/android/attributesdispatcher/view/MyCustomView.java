package com.ebr163.android.attributesdispatcher.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.EditText;

import com.ebr163.attributesdispatcher.Attribute;
import com.ebr163.attributesdispatcher.CustomView;
import com.ebr163.attributesdispatcher.attr.ColorAttr;
import com.ebr163.attributesdispatcher.attr.StringAttr;


/**
 * Created by mac1 on 24.11.16.
 */

@CustomView("com.ebr163.android.attributesdispatcher")
public class MyCustomView extends EditText {

    @ColorAttr(value = "custom_color", defaultValue = Color.GREEN)
    public int color;
    @StringAttr(value = "custom_text", defaultValue = "adasdasd")
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
    protected void setCustomAttr(@ColorAttr(value = "custom_color", defaultValue = Color.GREEN) int color) {
        this.setTextColor(color);
    }

    @Attribute
    protected void setCustomText(@StringAttr(value = "custom_text", defaultValue = "adasdasd1!!!") String text) {
        this.setText(text);
    }
}
