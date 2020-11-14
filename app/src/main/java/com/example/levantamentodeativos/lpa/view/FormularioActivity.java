package com.example.levantamentodeativos.lpa.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.levantamentodeativos.lpa.R;
import com.example.levantamentodeativos.lpa.controller.AtivosController;
import com.example.levantamentodeativos.lpa.model.AtivoModel;
import com.google.android.material.snackbar.Snackbar;

public class FormularioActivity extends AppCompatActivity {
    ImageView imvAtivo;
    Drawable drawable;
    EditText etNomeAtivo;
    EditText etMarca;
    EditText etModelo;
    EditText etNumSerie;
    EditText etPatrimonio;
    EditText etSO;
    EditText etProcessador;
    EditText etRam;
    EditText etHDSSD;
    EditText etObs;
    Spinner spOrigem;
    Spinner spSetor;
    RadioGroup rgArquiteturas;
    RadioButton rbArquit;
    Button btCadastrar;
    AlertDialog alerta;
    AtivoModel objAtivo;
    ConstraintLayout constraintCPU_MPC;
    ConstraintLayout constraintNomeOutros;

    int visivel = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

    //Busca os layouts de objetos
        imvAtivo = findViewById(R.id.imv_ativo);
        etNomeAtivo = findViewById(R.id.et_equip_outros);
        etMarca = findViewById(R.id.et_marca);
        etModelo = findViewById(R.id.et_modelo);
        etNumSerie = findViewById(R.id.et_num_serie);
        etPatrimonio = findViewById(R.id.et_patrimonio);
        etSO = findViewById(R.id.et_so);
        etProcessador = findViewById(R.id.et_processador);
        etRam = findViewById(R.id.et_ram);
        etHDSSD = findViewById(R.id.et_hd);
        etObs = findViewById(R.id.et_obs);
        spOrigem = findViewById(R.id.sp_origem);
        spSetor = findViewById(R.id.sp_setor);
        rgArquiteturas = findViewById(R.id.rg_arquit);
        btCadastrar = findViewById(R.id.bt_cadastrar);
        constraintCPU_MPC = findViewById(R.id.ct_DadosCPU);
        constraintNomeOutros = findViewById(R.id.ct_nome_outros);
    //---

    //Define os campos SO, RAM, HD/SDD como invisíveis
        constraintCPU_MPC.setVisibility(View.GONE);
    //Define o campo do nome do ativo/equipamento como invisível
        constraintNomeOutros.setVisibility(View.GONE);

    //Muda a imagem icone da tela de cadastro
        switch (SplashScreen.ATIVO) {
            case "CPU":
                drawable = getDrawable(R.drawable.cpu);
                constraintCPU_MPC.setVisibility(View.VISIBLE); //Define os campos SO, RAM, HD/SDD como visíveis

                break;
            case "Monitor":
                drawable = getDrawable(R.drawable.monitor);
                break;
            case "Nobreak":
                drawable = getDrawable(R.drawable.nobreak);
                break;
            case "Swicht":
                drawable = getDrawable(R.drawable.swicht);
                break;
            case "Impressora":
                drawable = getDrawable(R.drawable.impressora);
                break;
            case "Televisor":
                drawable = getDrawable(R.drawable.televisor);
                break;
            case "Monitor Touch":
                drawable = getDrawable(R.drawable.monitor_touch);
                break;
            case "Mini PC":
                drawable = getDrawable(R.drawable.minipc);
                constraintCPU_MPC.setVisibility(View.VISIBLE);
                break;
            case "Estabilizador":
                drawable = getDrawable(R.drawable.estabilizador);
                break;
            case "Aquecedor":
                drawable = getDrawable(R.drawable.aquecedor);
                break;
            case "Telefone":
                drawable = getDrawable(R.drawable.telefone);
                break;
            case "Outros":
                drawable = getDrawable(R.drawable.outros);
                constraintNomeOutros.setVisibility(View.VISIBLE); //Define os campos SO, RAM, HD/SDD como visíveis

                break;
        }

        imvAtivo.setImageDrawable(drawable);
    //----Termina de verificar a imagem ícone e aplica

    //Ação do botão de cadastro
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spSelectedSetor = spSetor.getSelectedItemPosition();
                int spSelectedOrigem = spOrigem.getSelectedItemPosition();
                int radioSelected = rgArquiteturas.getCheckedRadioButtonId();
                boolean verificacao=false;

            //Verificando se os campos estão preenchidos
                if(etNomeAtivo.getText().toString().equals("") && SplashScreen.ATIVO.equals("Outros")){
                    Snackbar.make(v,"Campo \"Equipamento/Ativo\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(etMarca.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Marca\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(etModelo.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Modelo\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(etNumSerie.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Nº de Série\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(etPatrimonio.getText().toString().equals("")){
                    Snackbar.make(v,"Campo \"Patrimonio\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(spSelectedOrigem==0){
                    Snackbar.make(v,"Campo \"Origem\" em branco", Snackbar.LENGTH_LONG).show();
                }else if(spSelectedSetor==0){
                    Snackbar.make(v,"Campo \"Setor\" em branco", Snackbar.LENGTH_LONG).show();
                }else{
                    verificacao=true;
                }

                if(SplashScreen.ATIVO.equals("CPU") || SplashScreen.ATIVO.equals("Mini PC")){
                    verificacao=false;
                    if(etSO.getText().toString().equals("")){
                        Snackbar.make(v,"Campo \"Sistema Operacional\" em branco", Snackbar.LENGTH_LONG).show();
                    }else if(radioSelected == -1){
                        Snackbar.make(v,"Selecione uma arquitetura (x86 ou x64)", Snackbar.LENGTH_LONG).show();
                    }else if(etProcessador.getText().toString().equals("")){
                        Snackbar.make(v,"Campo \"Processador\" em branco", Snackbar.LENGTH_LONG).show();
                    }else if(etRam.getText().toString().equals("")){
                        Snackbar.make(v,"Campo \"RAM\" em branco", Snackbar.LENGTH_LONG).show();
                    }else if(etHDSSD.getText().toString().equals("")){
                        Snackbar.make(v,"Campo \"HD/SSD\" em branco", Snackbar.LENGTH_LONG).show();
                    }else{
                        verificacao=true;
                    }

            //----Fim da verificação
                }
                    if(verificacao==true){
                    objAtivo = new AtivoModel();
                    objAtivo.setAnalista(SplashScreen.ANALISTA);
                    objAtivo.setUnidade(SplashScreen.UNIDADE);
                    if(SplashScreen.ATIVO.equals("Outros")){
                        objAtivo.setAtivo(etNomeAtivo.getText().toString());
                    }else {
                        objAtivo.setAtivo(SplashScreen.ATIVO);
                    }
                    objAtivo.setMarca(etMarca.getText().toString());
                    objAtivo.setModelo(etModelo.getText().toString());
                    objAtivo.setNumserie(etNumSerie.getText().toString());
                    objAtivo.setPatrimonio(etPatrimonio.getText().toString());
                    objAtivo.setOrigem(spOrigem.getSelectedItem().toString());
                    objAtivo.setSetor(spSetor.getSelectedItem().toString());
                    objAtivo.setSistemaOperacional(etSO.getText().toString());
                    rbArquit = findViewById(radioSelected);
                    if(radioSelected != -1){
                        objAtivo.setArquitetura(rbArquit.getText().toString());
                    }else
                        objAtivo.setArquitetura("");
                    objAtivo.setProcessador(etProcessador.getText().toString());
                    objAtivo.setRam(etRam.getText().toString());
                    objAtivo.setHdssd(etHDSSD.getText().toString());
                    objAtivo.setObs(etObs.getText().toString());

                    AtivosController ativosController = new AtivosController(getBaseContext());
                    boolean sucesso = ativosController.salvar(objAtivo);
                    String msgValidacao="";
                    if (sucesso){
                        msgValidacao = "Ativo Cadastrado";
                    }else{
                        msgValidacao = "Erro ao Cadastrar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(FormularioActivity.this);
                    builder.setTitle(msgValidacao);
                    String dadosCPU;
                    if(SplashScreen.ATIVO.equals("CPU") || SplashScreen.ATIVO.equals("Mini PC")){
                        dadosCPU = "\nSistema Operacional: "+objAtivo.getSistemaOperacional()+
                                "\nProcessador: "+objAtivo.getProcessador()+
                                "\nRAM: "+objAtivo.getRam()+
                                " GB\nHD/SSD: "+objAtivo.getHdssd();
                    }else
                        dadosCPU="";
                    builder.setMessage(objAtivo.getAtivo()+
                            "\nMarca: "+objAtivo.getMarca()+
                            "\nModelo: "+objAtivo.getModelo()+
                            "\nNº de Série: "+objAtivo.getNumserie()+
                            "\nPatrimônio: "+objAtivo.getPatrimonio()+
                            "\nOrigem: "+objAtivo.getOrigem()+
                            "\nSetor: "+objAtivo.getSetor()+
                            dadosCPU+
                            "\nObs: "+objAtivo.getObs());
                    builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    alerta = builder.create();
                    alerta.show();
                }
            }
        });

    }
}
