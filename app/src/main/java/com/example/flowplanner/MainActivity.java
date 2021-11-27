package com.example.flowplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText isim=findViewById(R.id.isim_edittext);

        findViewById(R.id.button_basla).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,menu.class);
                i.putExtra("kullanici",isim.getText().toString());
                startActivity(i);

            }
        });

    }
}
