package com.example.vc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registervcfinal extends AppCompatActivity {
    EditText name,email,phone,password;
    Button register;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vcreg);
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        phone=(EditText) findViewById(R.id.phone);
        password=(EditText) findViewById(R.id.password);
        DB = new DBHelper(this);
        register=(Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 =name.getText().toString();
                String email1=email.getText().toString();
                String phone1 =phone.getText().toString();
                String password1=password.getText().toString();



                if(name1.equals("")|| password1.equals("")|| phone1.equals("")|| password1.equals(""))
                    Toast.makeText(registervcfinal.this, "ente all fields", Toast.LENGTH_SHORT).show();
                Boolean insert = DB.insertData(name1,email1,phone1,password1);
                if(insert==true){
                    Toast.makeText(registervcfinal.this, "Register succeffully", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(getApplicationContext(),VCLoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}