package com.tree.xmlstyler;

import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by talhaaits on 2/15/18.
 */

public  class AnnotationProcessor {

    static public void Process(Object context) {
        for (Field field : context.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Style.class)) {
                Style style = field.getAnnotation(Style.class);
                field.setAccessible(true);
                try {
                    if(field.getType().isAssignableFrom(TextView.class)) {
                        TextView textView = (TextView) field.get(context);
                        textView.setText(style.title());
                    }
                    else if(field.getType().isAssignableFrom(String.class)){
                        field.set(context, style.title());
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
