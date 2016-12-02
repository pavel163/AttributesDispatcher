package com.ebr163.attributesdispatcher.attr;

/**
 * Created by mac1 on 29.11.16.
 */

public @interface IntAttr {
    String value();

    int maxSdkVersion() default 0;
}
