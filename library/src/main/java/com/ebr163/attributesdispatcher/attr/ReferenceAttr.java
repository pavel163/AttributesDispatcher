package com.ebr163.attributesdispatcher.attr;

/**
 * Created by mac1 on 29.11.16.
 */

public @interface ReferenceAttr {
    String value();

    int defaultValue() default -1;
    int maxSdkVersion() default 0;
}
