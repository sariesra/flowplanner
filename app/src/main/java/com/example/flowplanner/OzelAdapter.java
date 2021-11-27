package com.example.flowplanner;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import android.app.Activity;
import  android.content.Context;
import android.widget.TextView;
import java.util.Date;

public class OzelAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<akis>     mKisiListesi;

    public OzelAdapter(Activity activity, List<akis> kisiler) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        mKisiListesi = kisiler;
    }

    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    @Override
    public akis getItem(int position) {
        //şöyle de olabilir: public Object getItem(int position)
        return mKisiListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;

        satirView = mInflater.inflate(R.layout.activity_satir_layout, null);
        TextView textView_id =
                (TextView) satirView.findViewById(R.id.id);
        TextView textView_isadi =
                (TextView) satirView.findViewById(R.id.isadi);
        TextView textView_deadline =
                (TextView) satirView.findViewById(R.id.deadline);

        akis akis = mKisiListesi.get(position);

        textView_id.setText(String.format("%d ",akis.getId()));
        textView_isadi.setText(akis.getName());
        textView_deadline.setText(String.format("%d %d %d", akis.getDead_yil(), akis.getDead_ay(), akis.getDead_gun()));


        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
        Date simdikiZaman = new Date();
        String deadline = akis.getDead_yil()+"/"+akis.getDead_ay()+"/"+akis.getDead_gun();
       // Date d1 = format.parse(simdikiZaman);
        Date d2 = null;
        try {
            d2 = format.parse(deadline);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (simdikiZaman.getTime()>d2.getTime())
        {

            textView_id.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_isadi.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_deadline.setBackgroundColor(Color.rgb(255, 0, 0));
        }
        //yıl geçmisse
        /*if (simdikiZaman.getYear()<akis.getDead_yil()) {
            textView_id.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_isadi.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_deadline.setBackgroundColor(Color.rgb(255, 0, 0));

        }


        //ay gecisse
        else if ((simdikiZaman.getMonth()<akis.getDead_ay())&&(simdikiZaman.getYear()==akis.getDead_yil()))
        {
            textView_id.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_isadi.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_deadline.setBackgroundColor(Color.rgb(255, 0, 0));

        }
        //gun olarak geçmisse
        else if ((simdikiZaman.getDay()<akis.getDead_gun())&&(simdikiZaman.getMonth()==akis.getDead_ay())&&(simdikiZaman.getYear()==akis.getDead_yil()))
        {
            textView_id.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_isadi.setBackgroundColor(Color.rgb(255, 0, 0));
            textView_deadline.setBackgroundColor(Color.rgb(255, 0, 0));


        }*/


            return satirView;
    }
}
