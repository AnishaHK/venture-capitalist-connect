package com.example.vc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button vcLoginButton = findViewById(R.id.vclogin);
        vcLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start VCLoginActivity
                Intent intent = new Intent(LoginActivity.this, VCLoginActivity.class);
                startActivity(intent);
            }
        });



        // Your login activity code goes here
    }
}
