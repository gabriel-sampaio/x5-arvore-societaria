package com.arvore.gabriel.arvore;

import android.content.Context;

import java.util.List;

/**
 * Created by gabriel on 06/07/17.
 */

public class InvestimentoController {

    private static EmpresaDAO empresaDAO;
    private static InvestimentoDAO investimentoDAO;
    private static InvestimentoController instance;
    private static EmpresaController instanceEmpresa;


    public static InvestimentoController getInstance(Context context) {
        if (instance == null) {
            instance = new InvestimentoController();
            investimentoDAO = new InvestimentoDAO(context);
        }
        return instance;
    }

    public void insert(Investimento investimento) throws Exception {
        investimentoDAO.insert(investimento);
    }

    public void update(Investimento investimento) throws Exception {
        investimentoDAO.update(investimento);
    }

    public List<Investimento> findAll() throws Exception {
        return investimentoDAO.findAll();
    }
}
