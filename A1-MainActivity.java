package com.example.pro1pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "ON_CREATE", Toast.LENGTH_SHORT).show();
        btn=findViewById(R.id.btn);
        textView=findViewById(R.id.textview);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "CLICKED", Toast.LENGTH_SHORT).show();
                textView.setText("Button Clicked");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "ON_START", Toast.LENGTH_SHORT).show();
   }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "ON_PAUSE", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "ON_RESUME", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "ON_STOP", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ON_DESTROY", Toast.LENGTH_SHORT).show();
    }
}
