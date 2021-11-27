package com.example.flowplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i=getIntent();

        String kullanici= i.getStringExtra("kullanici");
        final Button mevcut_goruntule=findViewById(R.id.mevcut_akis_button);
        final Button akis_ekle=findViewById(R.id.yeni_akis_button);


        TextView mrb=findViewById(R.id.merhaba_text);
        mrb.setText(getResources().getString(R.string.merhaba) +" "+kullanici.toString());

        findViewById(R.id.yeni_akis_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(menu.this,yeni_akis.class);
                startActivity(i);
            }
        });

        findViewById(R.id.mevcut_akis_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1= new Intent(menu.this,mevcut_akislar.class);
                startActivity(i1);
            }
        });

    }
}
