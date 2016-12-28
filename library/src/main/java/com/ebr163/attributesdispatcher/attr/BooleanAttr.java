package com.ebr163.attributesdispatcher.attr;

/**
 * Created by mac1 on 29.11.16.
 */

public @interface BooleanAttr {
    String value();

    boolean defaultValue() default false;
    int maxSdkVersion() default 0;
}
