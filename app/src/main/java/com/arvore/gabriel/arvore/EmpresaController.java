package com.arvore.gabriel.arvore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by gabriel on 03/07/17.
 */

public class EmpresaController {

    private static EmpresaDAO empresaDAO;
    private static EmpresaController instance;

    public static EmpresaController getInstance(Context context) {
        if (instance == null) {
            instance = new EmpresaController();
            empresaDAO = new EmpresaDAO(context);
        }
        return instance;
    }

    public void insert(Empresa empresa) throws Exception {
        empresaDAO.insert(empresa);
    }

    public void update(Empresa empresa) throws Exception {
        empresaDAO.update(empresa);
    }

    public List<Empresa> findAll() throws Exception {
        return empresaDAO.findAll();
    }

    public List<Empresa> findAllNome() throws Exception {
        return empresaDAO.getAllNome();
    }
}

