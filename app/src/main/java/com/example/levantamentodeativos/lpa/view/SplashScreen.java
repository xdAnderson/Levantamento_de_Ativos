package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.levantamentodeativos.lpa.R;
import com.example.levantamentodeativos.lpa.datasource.DataSource;

public class SplashScreen extends AppCompatActivity {
    public static String ANALISTA = "";
    public static String UNIDADE = "";
    public static String ATIVO = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                DataSource ds = new DataSource((getBaseContext()));
                Intent intent = new Intent(SplashScreen.this, AnalistUnidadesActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}






