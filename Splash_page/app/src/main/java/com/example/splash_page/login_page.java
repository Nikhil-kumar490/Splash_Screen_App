package com.example.splash_page;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_page extends AppCompatActivity {
    EditText email,password;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn);

        // To make Button click able
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Mail = email.getText().toString();
                String Pass = password.getText().toString();

                if (!Mail.isEmpty() && !Pass.isEmpty()) {
                    if (Mail.equals("nikhil@gmail.com")) {
                        if (Pass.equals("1234")) {
                            Intent intent = new Intent(login_page.this, Home.class);
                            startActivity(intent);
                            finish();
                            if (Pass.equals("1234")){
                                Toast.makeText(login_page.this, "Le Gandu", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(login_page.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(login_page.this, "Wrong Email", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(login_page.this, "Fill the credentials", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}