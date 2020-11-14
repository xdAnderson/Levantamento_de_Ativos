package com.example.levantamentodeativos.lpa.datamodel;

public class AtivoDataModel {

    private final static String TABELA = "ativos";

    private final static String id = "id";
    private final static String analista = "analista";
    private final static String unidade = "unidade";
    private final static String ativo = "ativo";
    private final static String marca = "marca";
    private final static String modelo = "modelo";
    private final static String numserie = "numeroserie";
    private final static String patrimonio = "patrimonio";
    private final static String origem = "origem";
    private final static String setor = "setor";
    private final static String sistemaoperacional = "sistemaoperacional";
    private final static String arquitetura = "arquitetura";
    private final static String processador = "processador";
    private final static String ram = "ram";
    private final static String hdssd = "hdssd";
    private final static String obs = "obs";

    private static String queryCriarTabela = "";

    public static String criarTabela(){
        queryCriarTabela = "CREATE TABLE "+TABELA;
        queryCriarTabela += " (";
        queryCriarTabela += id+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += analista +" TEXT, ";
        queryCriarTabela += unidade+" TEXT, ";
        queryCriarTabela += ativo+" TEXT, ";
        queryCriarTabela += marca+" TEXT, ";
        queryCriarTabela += modelo+" TEXT, ";
        queryCriarTabela += numserie+" TEXT, ";
        queryCriarTabela += patrimonio+" TEXT, ";
        queryCriarTabela += origem+" TEXT, ";
        queryCriarTabela += setor+" TEXT, ";
        queryCriarTabela += sistemaoperacional+" TEXT, ";
        queryCriarTabela += processador+" TEXT, ";
        queryCriarTabela += arquitetura+" TEXT, ";
        queryCriarTabela += ram+" TEXT, ";
        queryCriarTabela += hdssd+" TEXT, ";
        queryCriarTabela += obs+" TEXT";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getAnalista() {
        return analista;
    }

    public static String getUnidade() {
        return unidade;
    }

    public static String getAtivo() {
        return ativo;
    }

    public static String getMarca() {
        return marca;
    }

    public static String getModelo() {
        return modelo;
    }

    public static String getNumserie() {
        return numserie;
    }

    public static String getPatrimonio() {
        return patrimonio;
    }

    public static String getOrigem() {
        return origem;
    }

    public static String getSetor() {
        return setor;
    }

    public static String getSistemaoperacional() {
        return sistemaoperacional;
    }

    public static String getArquitetura() {
        return arquitetura;
    }

    public static String getProcessador() {
        return processador;
    }

    public static String getRam() {
        return ram;
    }

    public static String getHdssd() {
        return hdssd;
    }

    public static String getObs() {
        return obs;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        AtivoDataModel.queryCriarTabela = queryCriarTabela;
    }



}

