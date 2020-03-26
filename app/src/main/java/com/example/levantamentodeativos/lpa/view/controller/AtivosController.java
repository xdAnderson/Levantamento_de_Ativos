package com.example.levantamentodeativos.lpa.view.controller;
import android.content.ContentValues;
import android.content.Context;
import androidx.annotation.Nullable;

import com.example.levantamentodeativos.lpa.view.datamodel.AtivoDataModel;
import com.example.levantamentodeativos.lpa.view.datasource.DataSource;
import com.example.levantamentodeativos.lpa.view.model.AtivoModel;

import java.util.List;

public class AtivosController extends DataSource {
    ContentValues dados;
    public AtivosController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(AtivoModel obj){
        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(AtivoDataModel.getDupla(),obj.getDupla());
        dados.put(AtivoDataModel.getUnidade(),obj.getUnidade());
        dados.put(AtivoDataModel.getAtivo(),obj.getAtivo());
        dados.put(AtivoDataModel.getMarca(),obj.getMarca());
        dados.put(AtivoDataModel.getModelo(),obj.getModelo());
        dados.put(AtivoDataModel.getNumserie(),obj.getNumserie());
        dados.put(AtivoDataModel.getPatrimonio(),obj.getPatrimonio());
        dados.put(AtivoDataModel.getSetor(),obj.getSetor());
        dados.put(AtivoDataModel.getObs(),obj.getObs());

        sucesso = insert(AtivoDataModel.getTABELA(), dados);
        return sucesso;
    }

    public List<AtivoModel> listar(){
        return getAllAtivos();
    }
}
