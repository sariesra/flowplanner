package com.example.flowplanner;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.List;

public class yeni_akis extends ListActivity {

    Button btnTarihSec;
    EditText etTarih;
    Context context = this;

    int dead_yil;
    int dead_ay;
    int dead_gun;

   // String[][] isparcalari = new String[20][4];
     veri_kaynagi vk;
    int is_sayisi=11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_akis);

        vk=new veri_kaynagi(this);
        vk.ac();//veritabanı baglantısı acık simdi baglancaz

      List<akis> akıslar=vk.listele();
      final ArrayAdapter<akis> adaptor=new ArrayAdapter<akis>(this,android.R.layout.simple_list_item_1,akıslar);
    setListAdapter(adaptor);

        btnTarihSec = (Button) findViewById(R.id.button_tarih_sec);
        etTarih = (EditText) findViewById(R.id.edittext_tarih);

        btnTarihSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                    // Şimdiki zaman bilgilerini alıyoruz. güncel yıl, güncel ay, güncel gün.
                    final Calendar takvim = Calendar.getInstance();
                    final int yil = takvim.get(Calendar.YEAR);
                    final int ay = takvim.get(Calendar.MONTH);
                    final int gun = takvim.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dpd = new DatePickerDialog(context,
                            new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            // ay değeri 0 dan başladığı için (Ocak=0, Şubat=1,..,Aralık=11)
                            // değeri 1 artırarak gösteriyoruz.
                            month += 1;
                            // year, month ve dayOfMonth değerleri seçilen tarihin değerleridir.
                            // Edittextte bu değerleri gösteriyoruz.
                            etTarih.setText(dayOfMonth + "/" + month + "/" + year);

                            dead_yil = year;
                            dead_ay = month;
                            dead_gun = dayOfMonth;
                        }
                        }, yil, ay, gun);
                // datepicker açıldığında set edilecek değerleri buraya yazıyoruz.
                // şimdiki zamanı göstermesi için yukarda tanmladığımz değşkenleri kullanyoruz.

                // dialog penceresinin button bilgilerini ayarlıyoruz ve ekranda gösteriyoruz.
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();
                }

        });

        findViewById(R.id.button_ekle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String is_adi=((EditText)findViewById(R.id.editText_is)).getText().toString();
                    akis a=new akis(is_sayisi,is_adi, dead_yil,dead_ay,dead_gun );
                    vk.akisolustur(a);
                    adaptor.add(a);
                    is_sayisi++;




            }
        });


    }


    protected void onResume(){
        vk.ac();
        super.onResume();
    }

    protected  void onPause(){
        vk.kapa();
        super.onPause();


    }


}
