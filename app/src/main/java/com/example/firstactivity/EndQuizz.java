package com.example.firstactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class EndQuizz extends AppCompatActivity {
    private Button btn_dinnou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quizz);
        initComponents();
        btn_dinnou.setOnClickListener(reiaQuizEvent());

    }

    private void initComponents() {
        btn_dinnou=findViewById(R.id.popa_margaret_btn_again);
    }

    private View.OnClickListener reiaQuizEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        };
    }
}