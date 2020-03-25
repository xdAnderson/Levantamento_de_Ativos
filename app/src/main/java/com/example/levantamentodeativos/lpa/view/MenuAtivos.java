package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.levantamentodeativos.lpa.R;

public class MenuAtivos extends AppCompatActivity {
    Button btCPU;
    Button btMonitor;
    Button btNobreak;
    Button btSwicht;
    Button btImpressora;
    Button btTelevisor;
    Button btMonitorTouch;
    Button btMiniPC;
    Button btEstabilizador;
    Button btAquecedor;
    Button btTelefone;
    Button btOutros;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ativos);

        btCPU = findViewById(R.id.bt_cpu);
        btMonitor = findViewById(R.id.bt_monitor);
        btNobreak = findViewById(R.id.bt_nobreak);
        btSwicht = findViewById(R.id.bt_swicht);
        btImpressora = findViewById(R.id.bt_impressora);
        btTelevisor = findViewById(R.id.bt_televisor);
        btMonitorTouch = findViewById(R.id.bt_monitor_touch);
        btMiniPC = findViewById(R.id.bt_minipc);
        btEstabilizador = findViewById(R.id.bt_estabilizador);
        btAquecedor = findViewById(R.id.bt_aquecedor);
        btTelefone = findViewById(R.id.bt_telefone);
        btOutros = findViewById(R.id.bt_outros);

        btCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "CPU";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Monitor";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btNobreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Nobreak";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btSwicht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Swicht";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btImpressora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Impressora";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btTelevisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Televisor";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btMonitorTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Monitor Touch";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btMiniPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Mini PC";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btEstabilizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Estabilizador";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btAquecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Aquecedor";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.ATIVO = "Telefone";
                intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        btOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuAtivos.this, OutrosActivity.class);
                startActivity(intent);
            }
        });




    }
}
