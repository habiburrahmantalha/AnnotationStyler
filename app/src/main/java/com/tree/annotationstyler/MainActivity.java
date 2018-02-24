package com.tree.annotationstyler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tree.xmlstyler.AnnotationProcessor;
import com.tree.xmlstyler.Style;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Style(text = "Hello!!")
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnnotationProcessor.Process(this,this);
        Log.d(TAG, "onCreate: " + title);
    }
}
