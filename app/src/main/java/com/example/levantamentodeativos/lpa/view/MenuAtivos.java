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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ativos);

        btCPU = findViewById(R.id.bt_cpu);
        btCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAtivos.this, FormularioActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}
