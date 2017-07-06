package com.arvore.gabriel.arvore;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.RadioButton;


public class CadastrarEmpresa extends AppCompatActivity {
    private EditText txtCnpj, txtRaz_soc;
    private Context context;
    private EmpresaController empresaController;
    private AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_empresa);
        context = this;
        empresaController = EmpresaController.getInstance(context);
        txtCnpj = (EditText) findViewById(R.id.txtCnpj);
        txtRaz_soc = (EditText) findViewById(R.id.txtRaz_soc);
        try {
            testaInicializacao();
        } catch (Exception e) {
            exibeDialogo("Erro inicializando banco de dados");
            e.printStackTrace();
        }

        Button button = (Button) findViewById(R.id.btnCadastrar);

        button.setOnClickListener(btnCadastrar);

    }

    public void testaInicializacao() throws Exception {
        if (empresaController.findAll().isEmpty()) {
            Empresa empresa = new Empresa(null, "Eoq S.A", "46177632000126", "LTDA");
            empresaController.insert(empresa);
        }
    }

    public void exibeDialogo(String mensagem) {
        alert = new AlertDialog.Builder(context);
        alert.setPositiveButton("OK", null);
        alert.setMessage(mensagem);
        alert.create().show();
    }

    public View.OnClickListener btnCadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String cnpj = txtCnpj.getText().toString();
            String raz_soc = txtRaz_soc.getText().toString();
            String tipo_emp = pegaRadioCheckado(view);

            if (txtCnpj == null | txtRaz_soc == null)
            {
                exibeDialogo("Há Campos vazios; Preencha-os Corretamente");
            }
            else {
                Empresa empresa = new Empresa(null, raz_soc, cnpj, tipo_emp);

                try {
                    empresaController.insert(empresa);
                    exibeDialogo("Empresa cadastrada com sucesso!");

                } catch (Exception e) {
                    exibeDialogo("Erro no cadastramento");
                    e.printStackTrace();
                }
            }
        }
    };

    public String pegaRadioCheckado(View view) {

        String tipo = "SA";
        RadioButton botaoltda;
        RadioButton botaosa;

        botaoltda = (RadioButton) findViewById(R.id.btnLTDA);
        botaosa = (RadioButton) findViewById(R.id.btnSA);

        if (botaoltda.isChecked())
            tipo = "LTDA";
        else
            if (botaosa.isChecked())
            tipo = "SA";
        else
            exibeDialogo("Selecione um tipo de empresa!");

        return tipo;
    }

 /*
    public void cadastrar(View view) {
        String cnpj = txtCnpj.getText().toString();
        String raz_soc = txtRaz_soc.getText().toString();
        String tipo_emp = pegaRadioCheckado(view);


        if (txtCnpj == null | txtRaz_soc == null) {
            exibeDialogo("Há Campos vazios; Preencha-os Corretamente");
        } else {
            Empresa empresa = new Empresa(null, raz_soc, cnpj, tipo_emp);

            try {
                empresaController.insert(empresa);
                exibeDialogo("Empresa cadastrada com sucesso!");

            } catch (Exception e) {
                exibeDialogo("Erro no cadastramento");
                e.printStackTrace();
            }
        }
    } */


}