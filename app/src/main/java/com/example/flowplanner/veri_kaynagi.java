package com.example.flowplanner;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class veri_kaynagi {

    SQLiteDatabase db;
    sql_katmani bdb;

    public veri_kaynagi(Context c){ bdb=new sql_katmani(c); }

    public void ac(){ db=bdb.getWritableDatabase(); }

    public void kapa(){ bdb.close(); }

    public void akisolustur(akis a){

        //id autoinc ben vermiyorum o kendi arttıracak
        ContentValues val=new ContentValues();
        val.put("name",a.getName());
        val.put("dead_yil",a.getDead_yil());
        val.put("dead_ay",a.getDead_ay());
        val.put("dead_gun",a.getDead_gun());
        db.insert("akis",null,val);
    }

    public List<akis> listele(){

        List<akis>liste=new ArrayList<akis>();

        String kolonlar[]={"id","name","dead_yil","dead_ay","dead_gun"};

        Cursor c = db.query("akis",kolonlar,null,null,null,null,null);
        c.moveToFirst();

        while (!c.isAfterLast())
        {
            int id =c.getInt(0);
            String name=c.getString(1);
            int dead_yil=c.getInt(2);
            int dead_ay=c.getInt(3);
            int dead_gun=c.getInt(4);

            //obje olarak kullanacaksak
            akis a=new akis(id,name,dead_yil,dead_ay,dead_gun);

            //com.example.flowplanner.akis tipinde listeye akisi ekledikk
            liste.add(a);
            c.moveToNext();
        }

        c.close();
        return  liste;
    }

    public void akis_sil(/*akis a*/)
    {
        /*int id=a.getId();
        db.delete("akis","id="+id,null);*/
        db.delete("akis",null,null);

    }


}
