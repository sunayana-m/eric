package com.example.a2_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    TextView myname;
    String namefromfirstactivity="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myname=findViewById(R.id.mytext);
        namefromfirstactivity=getIntent().getStringExtra("name");
        myname.setText(namefromfirstactivity);

    }
}
