package com.mark1.novem.appebook;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fontPath = "fonts/Cloud-Light.otf";
        TextView txtCloud = (TextView)findViewById(R.id.dsa);
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        txtCloud.setTypeface(tf);
    }
}
