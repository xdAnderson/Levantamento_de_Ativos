package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.levantamentodeativos.lpa.R;
import com.example.levantamentodeativos.lpa.controller.AtivosController;
import com.example.levantamentodeativos.lpa.datamodel.AtivoDataModel;
import com.example.levantamentodeativos.lpa.model.AtivoModel;
import com.example.levantamentodeativos.lpa.util.UtilAtivos;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AnalistUnidadesActivity extends AppCompatActivity {
    Spinner spUnidade;
    Button btIniciar;
    //Button btExtrair;
    RadioGroup rgAnalistas;
    RadioButton rbAnalista;
    AtivosController ativosController;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analist_unidades);

        spUnidade = findViewById(R.id.spn_unidades);
        btIniciar = findViewById(R.id.bt_ini_cad);
        //btExtrair = findViewById(R.id.bt_extrair);
        rgAnalistas = findViewById(R.id.rg_analistas);
        context = getBaseContext();
        ativosController = new AtivosController(context);

        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioSelected = rgAnalistas.getCheckedRadioButtonId();
                int spinnerSelected = spUnidade.getSelectedItemPosition();

                if(radioSelected!=-1) {
                    if(spinnerSelected==0){
                        Snackbar.make(v, "Selecione uma Unidade", Snackbar.LENGTH_LONG).show();
                    }else{
                        rbAnalista = findViewById(radioSelected);
                        SplashScreen.ANALISTA = rbAnalista.getText().toString();
                        SplashScreen.UNIDADE = spUnidade.getSelectedItem().toString();
                        Intent intent = new Intent(AnalistUnidadesActivity.this, MenuAtivos.class);
                        startActivity(intent);
                    }
                }else {
                    Snackbar.make(v, "Selecione seu nome", Snackbar.LENGTH_LONG).show();
                }
            }
        });

//        btExtrair.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SincronizarSistema task = new SincronizarSistema();
//                task.execute();
//            }
//        });

    }

//    private class SincronizarSistema extends AsyncTask<String, String, String>{
//        ProgressDialog progressDialog = new ProgressDialog(AnalistUnidadesActivity.this);
//        HttpURLConnection conn;
//        URL url = null;
//        Uri.Builder builder;
//
//        public SincronizarSistema(){
//            this.builder = new Uri.Builder();
//            builder.appendQueryParameter("app", "AtivosLPA");
//        }
//
//        @Override
//        protected void onPreExecute(){
//            progressDialog.setMessage("Enviando dados para a nuvem...");
//            progressDialog.setCancelable(false);
//            progressDialog.show();
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            //Monta URL com endereço do script PHP
//            try{
//                url = new URL(UtilAtivos.URL_WEB_SERVICE+"APISincronizarSistema.php");
//            }catch (MalformedURLException e){
//                Log.e("WebService","MalformedURLException - "+e.getMessage());
//            }catch (Exception erro){
//                Log.e("WebService","Exception - "+erro.getMessage());
//            }
//
//            try{
//                conn = (HttpURLConnection) url.openConnection();
//                conn.setConnectTimeout(UtilAtivos.CONNECTION_TIMEOUT);
//                conn.setReadTimeout(UtilAtivos.READ_TIMEOUT);
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("charset","utf-8");
//                conn.setDoInput(true);
//                conn.setDoOutput(true);
//
//
//                String query = builder.build().getEncodedQuery();
//                OutputStream os = conn.getOutputStream();
//                BufferedWriter writer = new BufferedWriter((new OutputStreamWriter(os, "UTF-8")));
//
//                writer.write(query);
//                writer.flush();
//                writer.close();
//                os.close();
//                conn.connect();
//            }catch (IOException e){
//                Log.e("WebService","IOExceptio - "+e.getMessage());
//            }
//
//            try{
//                int response_code = conn.getResponseCode();
//                if(response_code == HttpURLConnection.HTTP_OK){
//                    InputStream input = conn.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//                    StringBuilder result = new StringBuilder();
//                    String line;
//
//                    while((line = reader.readLine())!=null){
//                        result.append(line);
//                    }
//                    return (result.toString());
//                }else{
//                    return ("Erro de conexão");
//                }
//            }catch (Exception e){
//                Log.e("WebService","IOExceptio - "+e.getMessage());
//                return e.toString();
//            }finally {
//                conn.disconnect();
//            }
//
//
//        }
//
//        @Override
//        protected void onPostExecute(String result){
//            try{
//                JSONArray jsonArray = new JSONArray(result);
//                if(jsonArray.length()!=0){
//                    ativosController.deletarTabela(AtivoDataModel.getTABELA());
//                    ativosController.criarTabela(AtivoDataModel.criarTabela());
//
//                    for(int i = 0; i<jsonArray.length(); i++){
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        AtivoModel obj = new AtivoModel();
//                        obj.setId(jsonObject.getInt(AtivoDataModel.getId()));
//                        ativosController.salvar(obj);
//                    }
//                }
//            }catch (Exception e){
//
//            }finally {
//
//            }
//        }
//    }

}
