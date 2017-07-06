package com.arvore.gabriel.arvore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 05/07/17.
 */

public class InvestimentoDAO extends BancoDeDados {

    private final String TABLE = "empresa_empresa";
    private final String TABLEREL = "empresa";

    public InvestimentoDAO(Context context) {
        super(context);
    }

    public void insert(Investimento investimento) throws Exception {
        ContentValues values = new ContentValues();
        values.put("qtidade_inv", investimento.getQtidade_inv());
        values.put("id_investida", investimento.getId_investida());
        values.put("id_investidora", investimento.getId_investimento());
        getDatabase().insert(TABLE, null, values);
            }

    public void update(Investimento investimento)throws Exception {
        ContentValues values = new ContentValues();
        values.put("qtidade_inv", investimento.getQtidade_inv());
        values.put("id_investida", investimento.getId_investida());
        values.put("id_investidora", investimento.getId_investimento());
        getDatabase().insert(TABLE, null, values);
        getDatabase().update(TABLE, values, "id_investimento = ?", new String[] { "" + investimento.getId_investimento() });
    }
    public Investimento findById(Integer id_investimento) {
        String sql = "SELECT * FROM " + TABLE + " WHERE id_investimento = ?";
        String[] selectionArgs = new String[] { "" + id_investimento };
        Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
        cursor.moveToFirst();
        return montaInvestimento(cursor);
    }
    public List<Investimento> findAll() throws Exception {
        List<Investimento> retorno = new ArrayList<Investimento>();
        String sql = "SELECT * FROM " + TABLE;
        Cursor cursor = getDatabase().rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            retorno.add(montaInvestimento(cursor));
            cursor.moveToNext();
        }
        return retorno;
    }

    public Investimento montaInvestimento(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }

        Integer id_investimento = cursor.getInt(cursor.getColumnIndex("id_investimento"));
        Integer qtidade_inv = cursor.getInt(cursor.getColumnIndex("qtidade_inv"));
        Integer id_investidora = cursor.getInt(cursor.getColumnIndex("id_investidora"));
        Integer id_investida = cursor.getInt(cursor.getColumnIndex("id_investimento"));

       return new Investimento(id_investimento, qtidade_inv, id_investidora, id_investida);
    }    /**
     * @param id_investidora
     * @return
     */

    public Investimento findByInvestidora(Integer id_investidora) {
        String sql = "SELECT * FROM " + TABLE + " WHERE id_investidora = ?";
        String[] selectionArgs = new String[] { "" + id_investidora };
        Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);;
        cursor.moveToFirst();
        return montaInvestimento(cursor);
    }






}
