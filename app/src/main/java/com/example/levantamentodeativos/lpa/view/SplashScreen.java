package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.levantamentodeativos.lpa.R;

public class SplashScreen extends AppCompatActivity {
    public static String DUPLA = "";
    public static String UNIDADE = "";
    public static String ATIVO = "";
    public static String MARCA = "";
    public static String MODELO = "";
    public static String NSERIE = "";
    public static String PATRIMONIO = "";
    public static String SETOR = "";
    public static String OBS = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, DuplasUnidadesActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}
