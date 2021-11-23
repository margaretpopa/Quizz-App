package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Quizz extends AppCompatActivity {

    private TextView tv_nrIntrebari;
    private TextView scor;
    private TextView tv_intrebare;
    private ListView lv_raspunsuri;
    private Button btn_finish;
    private Button btn_next;
    private Integer NrIntrebare = 0;
    private boolean itemApasat=false;
    public Integer nr_scor=0;

    public static String cheie="SCOR";

    private Intrebare[] intrebari={
            new Intrebare("Cate saptamani are un an scolar?",1, new String[] {"12","34","8"}),
            new Intrebare("Este important studiul individual?",0, new String[] {"Adevarat","Fals"}),
            new Intrebare("Cate saptamani are un semestru universitar?",2, new String[] {"12","34","14","5"}),
            new Intrebare("Este importanta scoala in alegerea carierei?",0, new String[] {"DA","NU"}),
            new Intrebare("Cate clase sunt obligatorii in Romania?",2, new String[] {"12","4","10"}),
            new Intrebare("Ce clase cuprinde invatamantul primar?",1, new String[] {"Clasele I-IV","Clasa pregatitoare si clasele I-IV","Clasele V-VIII","0 clase"}),
            new Intrebare("Ce clase cuprinde invatamantul gimnazial?",1, new String[] {"Clasele I-IV","Clasele V-VIII","Anul 1 de facultate"}),
            new Intrebare("Cate probe scrise sunt obligatorii la Bacalaureat?",2, new String[] {"4","1","3"}),
            new Intrebare("Cate absente nemotivate duc la scaderea unui punct la purtare?",0, new String[] {"10","Nu se pot scadea puncte la purtare din nr absentelor nemotivate","50"}),
            new Intrebare("Este necesar ca studentul/elevul sa fie atent in timpul orelor/cursurilor?",0, new String[] {"DA","NU","Poate sa invete si singur acasa"})
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        initComponents();
        initializare(NrIntrebare);
        lv_raspunsuri.setOnItemClickListener(verificareRaspuns());
        btn_next.setOnClickListener(nextquestionEvent());
        btn_finish.setOnClickListener(finishEvent());
    }

    private View.OnClickListener finishEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),EndQuizz.class);


                Bundle bundle = new Bundle();
                bundle.putString(cheie,scor.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
    }

    private AdapterView.OnItemClickListener verificareRaspuns() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemApasat=true;

                for(int m = 0; m<intrebari[NrIntrebare].getRaspunsuri().length; m++)
                {
                    if(m==intrebari[NrIntrebare].getIDraspunsCorect()) {
                        lv_raspunsuri.getChildAt(m).setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.raspuns_corect));
                    }
                    else
                    {
                        lv_raspunsuri.getChildAt(m).setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.raspuns_gresit));
                    }
                }

                if(i==intrebari[NrIntrebare].getIDraspunsCorect())
                {
                    nr_scor++;
                    scor.setText(String.valueOf(nr_scor));
                }
            }
        };
    }


    private View.OnClickListener nextquestionEvent() {
       return new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(itemApasat==true )  {
                   NrIntrebare++;
                   initializare(NrIntrebare);
               }
               else
               {
               Toast.makeText(getApplicationContext(),R.string.alege_un_raspuns,Toast.LENGTH_LONG).show();
               }
               itemApasat=false;
           }
       };

    }

    private void initializare(int i) {
        if(i>=0 && i<intrebari.length-1) {
            btn_finish.setVisibility(View.GONE);
        }
        else
        {
            btn_finish.setVisibility(View.VISIBLE);
            btn_next.setVisibility(View.GONE);
        }
        tv_intrebare.setText(intrebari[i].getText());
        tv_nrIntrebari.setText(String.valueOf(i+1)+getString(R.string.bara_intrebari)+intrebari.length);
        scor.setText(nr_scor.toString());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,intrebari[i].getRaspunsuri());
        lv_raspunsuri.setAdapter(arrayAdapter);
    }

    private void initComponents() {
        tv_nrIntrebari=findViewById(R.id.popa_margaret_tv_nr_intrebari);
        scor=findViewById(R.id.popa_margaret_tv_scor);
        tv_intrebare=findViewById(R.id.popa_margaret_tv_intrebare);
        lv_raspunsuri=findViewById(R.id.popa_margaret_lv_raspunsuri);
        btn_finish=findViewById(R.id.popa_margaret_btn_finish);
        btn_next=findViewById(R.id.popa_margaret_btn_next);
    }
}