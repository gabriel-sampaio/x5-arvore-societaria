package com.arvore.gabriel.arvore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void CadastrarEmpresa(View view){

        Intent intent = new Intent(this, CadastrarEmpresa.class);
        startActivity(intent);
    }

    public void CadastrarInvestimento(View view){

        Intent intent = new Intent(this, CadastrarInvestimento.class);
        startActivity(intent);
    }

   /* public void proximaTela(View view){

        Intent intent = new Intent(this, VerArvore.class);
        startActivity(intent);
    } */
}
