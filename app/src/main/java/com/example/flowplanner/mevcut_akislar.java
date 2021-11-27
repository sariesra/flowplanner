package com.example.flowplanner;

import android.app.ListActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class mevcut_akislar extends ListActivity {

    veri_kaynagi vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mevcut_akislar);


        vk=new veri_kaynagi(this);
        vk.ac();//veritabanı baglantısı acık simdi baglancaz

        List<akis> akıslar=vk.listele();
        final ArrayAdapter<akis> adaptor=new ArrayAdapter<akis>(this,android.R.layout.simple_list_item_1,akıslar);
        setListAdapter(adaptor);

        final OzelAdapter adaptorumuz=new OzelAdapter(this, akıslar);
        final ListView listee=getListView();

        listee.setAdapter(adaptorumuz);

findViewById(R.id.sil_butonu).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        vk.akis_sil();
        adaptor.clear();

    }
});

    }


}

