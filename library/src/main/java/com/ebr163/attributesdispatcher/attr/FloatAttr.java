package com.ebr163.attributesdispatcher.attr;

/**
 * Created by mac1 on 29.11.16.
 */

public @interface FloatAttr {
    String value();

    float defaultValue() default 0;
    int maxSdkVersion() default 0;
}
