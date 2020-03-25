package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.levantamentodeativos.lpa.R;
import com.google.android.material.snackbar.Snackbar;

public class FormularioActivity extends AppCompatActivity {
    ImageView imvAtivo;
    Drawable drawable;
    EditText etMarca;
    EditText etModelo;
    EditText etNumSerie;
    EditText etPatrimonio;
    EditText etObs;
    Spinner spSetor;
    Button btCadastrar;
    AlertDialog alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

    //Busca os layouts de objetos
        imvAtivo = findViewById(R.id.imv_ativo);
        etMarca = findViewById(R.id.et_marca);
        etModelo = findViewById(R.id.et_modelo);
        etNumSerie = findViewById(R.id.et_num_serie);
        etPatrimonio = findViewById(R.id.et_patrimonio);
        etObs = findViewById(R.id.et_obs);
        spSetor = findViewById(R.id.sp_setor);
        btCadastrar = findViewById(R.id.bt_cadastrar);
    //---

    //Muda a imagem icone da tela de cadastro
        if(SplashScreen.ATIVO.equals("CPU")) {
            drawable = getDrawable(R.drawable.cpu);
        }else if(SplashScreen.ATIVO.equals("Monitor")){
            drawable = getDrawable(R.drawable.monitor);
        }else if(SplashScreen.ATIVO.equals("Nobreak")){
            drawable = getDrawable(R.drawable.nobreak);
        }else if(SplashScreen.ATIVO.equals("Swicht")){
            drawable = getDrawable(R.drawable.swicht);
        }else if(SplashScreen.ATIVO.equals("Impressora")){
            drawable = getDrawable(R.drawable.impressora);
        }else if(SplashScreen.ATIVO.equals("Televisor")){
            drawable = getDrawable(R.drawable.televisor);
        }else if(SplashScreen.ATIVO.equals("Monitor Touch")){
            drawable = getDrawable(R.drawable.monitor_touch);
        }else if(SplashScreen.ATIVO.equals("Mini PC")){
            drawable = getDrawable(R.drawable.minipc);
        }else if(SplashScreen.ATIVO.equals("Estabilizador")){
            drawable = getDrawable(R.drawable.estabilizador);
        }else if(SplashScreen.ATIVO.equals("Aquecedor")){
            drawable = getDrawable(R.drawable.aquecedor);
        }else if(SplashScreen.ATIVO.equals("Telefone")){
            drawable = getDrawable(R.drawable.telefone);
        }

        imvAtivo.setImageDrawable(drawable);
    //----Termina de verificar a imagem ícone e aplica

    //Ação do botão de cadastro
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spinnerSelected = spSetor.getSelectedItemPosition();
                if(etMarca.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Marca\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(etModelo.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Modelo\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(etNumSerie.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Nº de Série\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(etPatrimonio.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Patrimonio\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(spinnerSelected==0){
                    Snackbar.make(v,"Campo \"Setor\" em branco", Snackbar.LENGTH_LONG).show();
                }else{
                    SplashScreen.MARCA = etMarca.getText().toString();
                    SplashScreen.MODELO = etModelo.getText().toString();
                    SplashScreen.NSERIE = etNumSerie.getText().toString();
                    SplashScreen.PATRIMONIO = etPatrimonio.getText().toString();
                    SplashScreen.SETOR = spSetor.getSelectedItem().toString();
                    SplashScreen.OBS = etObs.getText().toString();

                    //Cria o gerador do AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                    //define o titulo
                    builder.setTitle("Ativo cadastrado");
                    //define a mensagem
                    builder.setMessage(SplashScreen.ATIVO+"\nMarca: "+SplashScreen.MARCA+"\nModelo: "
                            +SplashScreen.MODELO+"\nNº de Série: "+SplashScreen.NSERIE+"\nPatrimônio: "
                            +SplashScreen.PATRIMONIO+"\nSetor: "+SplashScreen.SETOR+"Obs: "+SplashScreen.OBS);
                    //define um botão como positivo
                    builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    //cria o AlertDialog
                    alerta = builder.create();
                    //Exibe
                    alerta.show();
                }
            }
        });

    }
}
