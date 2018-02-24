package com.tree.xmlstyler;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by talhaaits on 2/15/18.
 */

public  class AnnotationProcessor {

    static public void Process(Object object,Context context) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Style.class)) {
                Style style = field.getAnnotation(Style.class);
                field.setAccessible(true);
                try {
                    if(field.getType().isAssignableFrom(TextView.class)) {
                        TextView textView = (TextView) field.get(object);
                        if(!style.text().isEmpty())
                        textView.setText(style.text());

                        if (style.size() > 0)
                            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, style.size());
                        if (!style.font().isEmpty()) {
                            Typeface type = Typeface.createFromAsset(context.getAssets(), style.font());
                            textView.setTypeface(type);
                        }
                        if (!style.color().isEmpty()) {
                            textView.setTextColor(Color.parseColor(style.color()));
                        }
                    }
                    else if(field.getType().isAssignableFrom(String.class)){
                        if(!style.text().isEmpty())
                        field.set(context, style.text());
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
