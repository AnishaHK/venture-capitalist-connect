package com.example.vc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Startupregister extends AppCompatActivity {
    EditText name,email,phone,website,about;
    Button register;
    DBHelper1 DB;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startupreg);
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        phone=(EditText) findViewById(R.id.phone);
        website=(EditText) findViewById(R.id.website);
        about=(EditText) findViewById(R.id.about);
        register=(Button) findViewById(R.id.register);
        DB = new DBHelper1(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 =name.getText().toString();
                String email1=email.getText().toString();
                String phone1 =phone.getText().toString();
                String website1=website.getText().toString();
                String about1=about.getText().toString();



                if(name1.equals("")|| website1.equals("")|| phone1.equals("")|| email1.equals("")|| about1.equals(""))
                    Toast.makeText(Startupregister.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                Boolean insert = DB.insertData(name1,email1,phone1,website1,about1);
                if(insert==true){
                    Toast.makeText(Startupregister.this, "Register succeffully", Toast.LENGTH_SHORT).show();

                }
            }
        });

















    }
}
