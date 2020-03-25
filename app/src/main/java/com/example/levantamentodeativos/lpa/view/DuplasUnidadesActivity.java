package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.levantamentodeativos.lpa.R;
import com.google.android.material.snackbar.Snackbar;

public class DuplasUnidadesActivity extends AppCompatActivity {
    Spinner spUnidade;
    Button btIniciar;
    RadioGroup rgDuplas;
    RadioButton rbDupla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplas_unidades);

        spUnidade = findViewById(R.id.spn_unidades);
        btIniciar = findViewById(R.id.bt_ini_cad);
        rgDuplas = findViewById(R.id.rg_duplas);

        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioSelected = rgDuplas.getCheckedRadioButtonId();
                int spinnerSelected = spUnidade.getSelectedItemPosition();

                if(radioSelected!=-1) {
                    if(spinnerSelected==0){
                        Snackbar.make(v, "Selecione uma Unidade", Snackbar.LENGTH_LONG).show();
                    }else{
                        rbDupla = findViewById(radioSelected);
                        SplashScreen.DUPLA = rbDupla.getText().toString();
                        SplashScreen.UNIDADE = spUnidade.getSelectedItem().toString();
                        Intent intent = new Intent(DuplasUnidadesActivity.this, MenuAtivos.class);
                        startActivity(intent);
                    }
                }else {
                    Snackbar.make(v, "Selecione uma Dupla", Snackbar.LENGTH_LONG).show();
                }

            }
        });

    }
}
