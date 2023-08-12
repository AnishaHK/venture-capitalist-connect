package com.example.vc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button vcRegisterButton = findViewById(R.id.vcregister);
        vcRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the VCRegisterActivity
                Intent intent = new Intent(RegisterActivity.this, registervcfinal.class);
                startActivity(intent);
            }
        });

        Button startupRegisterButton = findViewById(R.id.startupregister);
        startupRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the StartupRegisterActivity
                Intent intent = new Intent(RegisterActivity.this, Startupregister.class);
                startActivity(intent);
            }
        });
    }
}
