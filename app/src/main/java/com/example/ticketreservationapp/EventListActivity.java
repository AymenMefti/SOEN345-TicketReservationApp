package com.example.ticketreservationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class EventListActivity extends AppCompatActivity {

    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        logoutButton = findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(v -> {
            // Sign out of Firebase
            FirebaseAuth.getInstance().signOut();

            // Return to the Login screen
            Intent intent = new Intent(EventListActivity.this, LoginActivity.class);
            // Clear the activity stack so the user can't press back to bypass the login screen
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}