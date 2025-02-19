package com.example.classdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView count;
    Button countClick,toastActivity;
    int pCount=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        count=findViewById(R.id.countView);
        countClick=findViewById(R.id.countOnClick);
        toastActivity=findViewById(R.id.toastOnClick);

        countClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pCount+=1;
                count.setText(""+pCount);
            }
        });

        toastActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pCount=0;
                count.setText(""+pCount);
                Toast.makeText(MainActivity.this, "Your Count is reset....", Toast.LENGTH_SHORT).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}