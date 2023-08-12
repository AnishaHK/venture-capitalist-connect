package com.example.vc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VCLoginActivity extends AppCompatActivity {
    EditText email, password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vclogin);
        email = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.login);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(VCLoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkUserPass = DB.checkusernamepassword(user,pass);
                    if (checkUserPass) {
                        Toast.makeText(VCLoginActivity.this, "Signin successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), vcdashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(VCLoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
