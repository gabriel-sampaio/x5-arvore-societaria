package com.arvore.gabriel.arvore;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Sampa on 29/06/2017.
 */

public class BancoDeDados extends SQLiteOpenHelper {

    private final static String NOME_BANCO = "arvoredb.db";
    private static final String CREATE = "CREATE TABLE empresa (id_emp INTEGER PRIMARY KEY AUTOINCREMENT, raz_soc VARCHAR(40), cnpj VARCHAR(14) UNIQUE, tipo_emp VARCHAR(4)); CREATE TABLE empresa_empresa (id INTEGER PRIMARY KEY AUTOINCREMENT, quantidade INTEGER, FOREIGN KEY(empresainvestida) REFERENCES empresa(id_emp), FOREIGN KEY (empresainvestidora) REFERENCES empresa(id_emp))";
    private static final int VERSAO = 1;

    public BancoDeDados(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS empresa" + "DROP TABLE IF EXISTS empresa_empresa");
        onCreate(db);

    }

    protected SQLiteDatabase database;
    public SQLiteDatabase getDatabase() {
        if (database == null) {
            database = getWritableDatabase();
        }
        return database;
    }

}
