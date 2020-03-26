package com.example.levantamentodeativos.lpa.view.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.levantamentodeativos.lpa.view.datamodel.AtivoDataModel;
import com.example.levantamentodeativos.lpa.view.model.AtivoModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class DataSource extends SQLiteOpenHelper {
private static final String DB_NAME = "levantamento_de_ativos.sqlite";
private static final int DB_VERSION = 1;
SQLiteDatabase db;
Cursor cursor;
    public DataSource(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(AtivoDataModel.criarTabela());
        }catch (Exception e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados){
        boolean sucesso = true;
        try{
            sucesso = db.insert(tabela, null, dados)>0;
        }catch (Exception e){
            sucesso = false;

        }
        return sucesso;
    }

    public List<AtivoModel> getAllAtivos(){
        AtivoModel obj;

        List<AtivoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM "+ AtivoDataModel.getTABELA();
        cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                obj = new AtivoModel();
                obj.setDupla(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getDupla())));
                obj.setUnidade(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getUnidade())));
                obj.setAtivo(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getAtivo())));
                obj.setModelo(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getModelo())));
                obj.setMarca(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getMarca())));
                obj.setNumserie(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getNumserie())));
                obj.setPatrimonio(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getPatrimonio())));
                obj.setSetor(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getSetor())));
                obj.setObs(cursor.getString(cursor.getColumnIndex(AtivoDataModel.getObs())));

                lista.add(obj);

            }while(cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public void salvarCVS(String dados){
        File caminho = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Levantamento_de_Ativos_LPA");
        if (!caminho.exists())
            caminho.mkdir();

        File file = new File(caminho.getPath()+"/BANCO_DE_ATIVOS.csv");

        try {
            FileOutputStream out = new FileOutputStream(file);

            out.write(dados.getBytes(), 0, dados.getBytes().length);
            //esse método write deve ficar dentro da estrutura de repetição

            //já essa parte de flush e close tem que ficar fora e
            //deve ser executada apenas quando já tiver terminado de gerar todo o arquivo
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}












