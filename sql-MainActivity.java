package com.example.sql_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button register,delete,display,update;
    EditText username,password;
    TextView result;

    private static final String dbname = "studentdb";
    private static final String tbname = "student";
    private static int dbVersion = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register=findViewById(R.id.regbtn);
        delete=findViewById(R.id.delbtn);
        display=findViewById(R.id.disbtn);
        update=findViewById(R.id.updbtn);

        username=findViewById(R.id.uname);
        password=findViewById(R.id.upasswod);

        result=findViewById(R.id.displayView);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbhel= new DBHelper(MainActivity.this,dbname, null,dbVersion);
                long ans= dbhel.addUser(username.getText().toString(),password.getText().toString());
                if(ans==-1)
                {
                    Toast.makeText(MainActivity.this, "Sorry, something went wrong!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Inserted!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbhel= new DBHelper(MainActivity.this,dbname, null,dbVersion);
                dbhel.update(username.getText().toString(),password.getText().toString());
                Toast.makeText(MainActivity.this, "Updated!", Toast.LENGTH_SHORT).show();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbhel= new DBHelper(MainActivity.this,dbname, null,dbVersion);
                String res=dbhel.display();

                result.setText(res);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbhel= new DBHelper(MainActivity.this,dbname, null,dbVersion);
                dbhel.delete(username.getText().toString());
                Toast.makeText(MainActivity.this, "Deleted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

