package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCOmponents();
        btn_start.setOnClickListener(openQuizzEvent());

    }

    private View.OnClickListener openQuizzEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Quizz.class);
                startActivity(intent);
            }
        };
    }

    private void initCOmponents() {
        btn_start=findViewById(R.id.popa_margaret_btn_start);
    }
}