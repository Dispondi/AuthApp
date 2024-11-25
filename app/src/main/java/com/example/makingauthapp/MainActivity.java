package com.example.makingauthapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.makingauthapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText paramA;
    private EditText paramB;
    private EditText paramC;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        paramA = findViewById(R.id.paramA);
        paramB = findViewById(R.id.paramB);
        paramC = findViewById(R.id.paramC);
        result = findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSolve();
            }
        });
        Log.i("Info", "App created");
    }

    private void doSolve() {
        double a;
        double b;
        double c;
        if (isNumeric(paramA.getText().toString()) && isNumeric(paramB.getText().toString()) && isNumeric(paramC.getText().toString())) {
            a = Double.parseDouble(paramA.getText().toString());
            b = Double.parseDouble(paramB.getText().toString());
            c = Double.parseDouble(paramC.getText().toString());
        } else {
            result.setText(R.string.not_solve);
            return;
        }
        double d = Math.round(Math.pow(b, 2) - 4 * a * c);
        double x1;
        double x2;

        // проверка на ноль
        if (a == 0) {
            result.setText(R.string.not_solve);
            return;
        }

        if (d > 0) {
            x1 = ((-b + Math.sqrt(d)) / (2 * a));
            x2 = ((-b - Math.sqrt(d)) / (2 * a));
            result.setText(String.format("x1 = %.2f, x2 = %.2f", x1, x2));
        } else if (d == 0) {
            x1 = ((-b + Math.sqrt(d)) / (2 * a));
            result.setText(String.format("x1,2 = %.2f", x1));
        } else {
            result.setText(R.string.not_solve);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}