package com.mulia754.dataperssatria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class keterangan extends AppCompatActivity {
    TextView tvView,tvNoHP;
    String valurl;
ImageView gambarInformasi;
Button btnTelpon,btnWA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan);
        gambarInformasi = findViewById(R.id.imgInformasi);
        tvView = (TextView) findViewById(R.id.tvKet1);
        valurl = getIntent().getExtras().getString("Value");
        tvView.setText(valurl);
        tvNoHP=findViewById(R.id.tvnoHP);
        btnTelpon = findViewById(R.id.btnTelpon);
        btnWA = findViewById(R.id.btnWhatsapp);
        //mengassign atau menentukan nilai url ke dalam bentuk editext string
       // String urlx = tvView.getText().toString();
        //ketika menekan tombol call maka akan melakukan dial

        // proses menambahkan Links pada TextView
        btnTelpon.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //number = inputan dari editText
                String toDial="tel:"+tvNoHP.getText().toString();

                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
            }
        });

        btnWA.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //number = inputan dari editText
                String toDial="https://api.whatsapp.com/send?phone="+"tel:"+tvNoHP.getText().toString();

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(toDial));
                startActivity(intent);
            }
        });
        setInfo(valurl);

    }
    public void setInfo(String valurl){
        if(valurl.equalsIgnoreCase("Mulia Adi Dharma")){gambarInformasi.setImageResource(R.drawable.mulia);tvNoHP.setText("+6282199728718");}
        else if(valurl.equalsIgnoreCase("Rangga Rajasa")){gambarInformasi.setImageResource(R.drawable.lepin);tvNoHP.setText("+6281240547733");}
        else if(valurl.equalsIgnoreCase("Araya Rajasa")){gambarInformasi.setImageResource(R.drawable.nurdin);tvNoHP.setText("+6281240547434");}
        else if(valurl.equalsIgnoreCase("Jaya Wardhana")){gambarInformasi.setImageResource(R.drawable.nicco);tvNoHP.setText("+6281240547745");}
        else if(valurl.equalsIgnoreCase("Karna Kartanagara")){gambarInformasi.setImageResource(R.drawable.kararbo);tvNoHP.setText("+6281240547722");}
        else if(valurl.equalsIgnoreCase("Dipa Kartarajasa")){gambarInformasi.setImageResource(R.drawable.rikel);tvNoHP.setText("+628124232733");}
}}

