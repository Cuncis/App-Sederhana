package com.boss.cuncis.appsederhana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    EditText etPanjang, etLebar;
    Button btnHitung;
    TextView tvHasil;
    ScrollView scrollView;
    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPanjang = findViewById(R.id.et_panjang);
        etLebar = findViewById(R.id.et_lebar);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        scrollView = findViewById(R.id.scrollViewMain);
        imgPoster = findViewById(R.id.img_main);

        Picasso.get().load("https://wallpaperplay.com/walls/full/c/e/b/44295.jpg").into(imgPoster);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = etPanjang.getText().toString();
                String lebar = etLebar.getText().toString();

                if (etPanjang.length() > 0 && etLebar.length() > 0) {
                    menghitungLuasPersegiPanjang(Integer.parseInt(panjang), Integer.parseInt(lebar));
                } else {
                    Toast.makeText(MainActivity.this, "Nilai tidak boleh kosong...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void menghitungLuasPersegiPanjang(int panjang, int lebar) {
        int hasil = panjang * lebar;

        tvHasil.setText(String.valueOf(hasil));
        scrollView.smoothScrollBy(0, scrollView.getBottom());
    }
}
