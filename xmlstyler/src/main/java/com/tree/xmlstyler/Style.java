package com.tree.xmlstyler;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by talhaaits on 2/15/18.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Style {
    String text() default "";
    float fontSize() default 0f;
    String fontLocation() default "";

    String textColor() default "";
}
