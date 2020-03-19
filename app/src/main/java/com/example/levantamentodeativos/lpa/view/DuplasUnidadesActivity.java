package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.levantamentodeativos.lpa.R;
import com.google.android.material.snackbar.Snackbar;

public class DuplasUnidadesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    Button btCadastrar;
    RadioGroup rgDuplas;
    RadioButton rbDupla;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplas_unidades);

        spinner = findViewById(R.id.spn_unidades);
        btCadastrar = findViewById(R.id.bt_ini_cad);
        rgDuplas = findViewById(R.id.rg_duplas);
        adapter = ArrayAdapter.createFromResource(this, R.array.unidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioSelected = rgDuplas.getCheckedRadioButtonId();
                int spinnerSelected = spinner.getSelectedItemPosition();
                if(radioSelected!=-1) {
                    if(spinnerSelected==0){
                        Snackbar.make(v, "Selecione uma Unidade", Snackbar.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(DuplasUnidadesActivity.this, MenuAtivos.class);
                        startActivity(intent);
                    }
                }else {
                    Snackbar.make(v, "Selecione uma Dupla", Snackbar.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
