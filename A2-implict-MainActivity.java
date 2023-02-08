package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call();
    }
    private void Call() {
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = findViewById(R.id.call);
                String show = e.getText().toString();
                Toast.makeText(MainActivity.this, "You typed "+show,
                        Toast.LENGTH_SHORT).show();
                Uri u = Uri.parse("tel:"+show);
                Intent i = new Intent(Intent.ACTION_DIAL,u);
                try {
                    startActivity(i);
                }
                catch (SecurityException s){
                    Toast.makeText(MainActivity.this, "An Error occurred",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
