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
    private TextView tv_scor_final;

    public static String cheie="SCOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quizz);
        initComponents();
        //primire scor
        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString(cheie);
        if (bundle.containsKey(Quizz.cheie))    {
            tv_scor_final.setText(value);
        }


        btn_dinnou.setOnClickListener(reiaQuizEvent());
    }

    private void initComponents() {
        btn_dinnou=findViewById(R.id.popa_margaret_btn_again);
        tv_scor_final=findViewById(R.id.popa_margaret_tv_scor_final);
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