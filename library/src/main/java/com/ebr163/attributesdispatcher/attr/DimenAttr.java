package com.ebr163.attributesdispatcher.attr;

/**
 * Created by mac1 on 29.11.16.
 */

public @interface DimenAttr {
    String value();

    float defaultValue() default 0f;
    int maxSdkVersion() default 0;
}
