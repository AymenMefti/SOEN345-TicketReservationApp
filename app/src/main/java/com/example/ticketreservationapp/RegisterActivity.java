package com.example.ticketreservationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;
    private Button registerButton;
    private RegistrationValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        validator = new RegistrationValidator();

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerEmailButton);

        registerButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (!validator.isValidEmail(email)) {
            emailEditText.setError("Please enter a valid email");
            return;
        }

        if (!validator.isValidPassword(password)) {
            passwordEditText.setError("Password must be at least 6 characters");
            return;
        }

        // Create user in Firebase
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();

                        // Send the new customer to the Event List page
                        Intent intent = new Intent(RegisterActivity.this, EventListActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}