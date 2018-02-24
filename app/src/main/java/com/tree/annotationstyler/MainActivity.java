package com.tree.annotationstyler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.tree.xmlstyler.AnnotationProcessor;
import com.tree.xmlstyler.Style;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Style(text = "Hello!!")
    String title;
    @Style(text = " Hello", size = 20f, color = "#888000")
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        AnnotationProcessor.Process(this,this);
        Log.d(TAG, "onCreate: " + title);


    }
}
