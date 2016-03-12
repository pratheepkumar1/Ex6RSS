package com.androiddev.justsvkthings.rssfeedex6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText title,link,description;
    Button b1,b2;
    private String finalUrl="http://tutorialspoint.com/android/sampleXML.xml";
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText) findViewById(R.id.editText);
        link = (EditText) findViewById(R.id.editText2);
        description = (EditText) findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj = new HandleXML(finalUrl);
                obj.fetchXML();

                while (obj.parsingComplete) ;
                title.setText(obj.getTitle());
                link.setText(obj.getLink());
                description.setText(obj.getDescription());
            }
        });
        System.out.println("Worked!");
    }
}
