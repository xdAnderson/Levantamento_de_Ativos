package com.example.levantamentodeativos.lpa.view.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.levantamentodeativos.lpa.R;
import com.example.levantamentodeativos.lpa.view.controller.AtivosController;
import com.example.levantamentodeativos.lpa.view.datasource.DataSource;
import com.example.levantamentodeativos.lpa.view.model.AtivoModel;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class DuplasUnidadesActivity extends AppCompatActivity {
    Spinner spUnidade;
    Button btIniciar;
    Button btExtrair;
    RadioGroup rgDuplas;
    RadioButton rbDupla;
    AtivosController ativosController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplas_unidades);

        spUnidade = findViewById(R.id.spn_unidades);
        btIniciar = findViewById(R.id.bt_ini_cad);
        btExtrair = findViewById(R.id.bt_extrair);
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

        btExtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ativosController = new AtivosController(DuplasUnidadesActivity.this);
                List<AtivoModel> objAtivos = ativosController.listar();
                String dados="";
                for (AtivoModel objAtivo:objAtivos) {
                    dados += objAtivo.getDupla()+";"+objAtivo.getUnidade()+
                            ";"+objAtivo.getAtivo()+";"+objAtivo.getMarca()+";"+objAtivo.getModelo()+
                            ";"+objAtivo.getNumserie()+";"+objAtivo.getPatrimonio()+
                            ";"+objAtivo.getSetor()+";"+objAtivo.getObs()+"\n";
                }

                ativosController.salvarCVS(dados);
                Log.i("ATIVOS", dados);
            }
        });

    }


}
