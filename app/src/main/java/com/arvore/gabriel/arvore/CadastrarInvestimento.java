package com.arvore.gabriel.arvore;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.arvore.gabriel.arvore.BancoDeDados;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CadastrarInvestimento extends AppCompatActivity {

    public Spinner spn;
    public Spinner spn1;
    private Context context;
    private EmpresaController empresaController;
    private InvestimentoController investimentoController;
    private AlertDialog.Builder alert;
    public EditText txtQtidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_investimento);

        context = this;
        empresaController = EmpresaController.getInstance(context);
        investimentoController = InvestimentoController.getInstance(context);
        spn = (Spinner) findViewById(R.id.spinnerInvestidora);
        spn1 = (Spinner) findViewById(R.id.spinnerInvestida);
        txtQtidade = (EditText) findViewById(R.id.txtQtidade);

        Button button = (Button) findViewById(R.id.btnRealizarInvestimento);

        button.setOnClickListener(btnRealizarInvestimento);

        try {
            loadSpinnerDataHama();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void exibeDialogo(String mensagem) {
        alert = new AlertDialog.Builder(context);
        alert.setPositiveButton("OK", null);
        alert.setMessage(mensagem);
        alert.create().show();
    }

    private void loadSpinnerDataHama() throws Exception {

        // database handler
        BancoDeDados db = new BancoDeDados(getApplicationContext());

        List<Empresa> lables = empresaController.findAll();
        // Criando adaptador para o spinner
        ArrayAdapter<Empresa> dataAdapter = new ArrayAdapter<Empresa>(this,
                android.R.layout.simple_spinner_item, lables);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Anexando adaptador de dados para o spinner

        spn.setAdapter(dataAdapter);
        spn1.setAdapter(dataAdapter);

    }

    public View.OnClickListener btnRealizarInvestimento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int id_investidora = Integer.parseInt(((Empresa) spn.getSelectedItem()).toString2());
            int id_investida = Integer.parseInt(((Empresa) spn1.getSelectedItem()).toString2());

            Integer qtidade = Integer.parseInt(txtQtidade.getText().toString());

            if (txtQtidade == null) {
                exibeDialogo("Preencha os dados corretamente!");
            } else {
                Investimento investimento = new Investimento(null, id_investidora, id_investida, qtidade);

                try {
                    investimentoController.insert(investimento);
                    exibeDialogo("Investimento realizado com sucesso!");
                } catch (Exception e) {
                    exibeDialogo("Erro no cadastramento");
                    e.printStackTrace();
                }


            }
        }
    };
}


