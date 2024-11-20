package com.example.makingauthapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.makingauthapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    static final String NAME = "Bob";
    static final String PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.EnterButton.setOnClickListener(v -> {
            String typedUsername = binding.UserName.getText().toString();
            String typedPassword = binding.Password.getText().toString();

            if (typedUsername.equals(NAME) && typedPassword.equals(PASSWORD)) {
                Toast.makeText(this, "Welcome, Bob", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Access denied", Toast.LENGTH_SHORT).show();
            }
        });

        binding.GiveUpButton.setOnClickListener(v -> {
            Toast.makeText(this, "I KNEW THAT YOU ARE NOT BOB!!1!", Toast.LENGTH_LONG).show();
            finishAffinity();
        });

        Log.i("Info", "App created");
    }
}