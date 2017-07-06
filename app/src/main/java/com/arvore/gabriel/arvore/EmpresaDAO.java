package com.arvore.gabriel.arvore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 03/07/17.
 */

public class EmpresaDAO extends BancoDeDados {

        private final String TABLE = "empresa";

        public EmpresaDAO(Context context) {
            super(context);
        }

        public void insert(Empresa empresa) throws Exception {
            ContentValues values = new ContentValues();
            values.put("raz_soc", empresa.getRaz_soc());
            values.put("cnpj", empresa.getCnpj());
            values.put("tipo_emp", empresa.getTipo_emp());
            getDatabase().insert(TABLE, null, values);
        }
        public void update(Empresa empresa)throws Exception {
            ContentValues values = new ContentValues();
            values.put("raz_soc", empresa.getRaz_soc());
            values.put("cnpj", empresa.getCnpj());
            values.put("tipo_emp", empresa.getTipo_emp());
            getDatabase().update(TABLE, values, "id_emp = ?", new String[] { "" + empresa.getId_emp() });
        }
        public Empresa findById(Integer id_emp) {
            String sql = "SELECT * FROM " + TABLE + " WHERE id_emp = ?";
            String[] selectionArgs = new String[] { "" + id_emp };
            Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
            cursor.moveToFirst();
            return montaEmpresa(cursor);
        }
        public List<Empresa> findAll() throws Exception {
            List<Empresa> retorno = new ArrayList<Empresa>();
            String sql = "SELECT * FROM " + TABLE;
            Cursor cursor = getDatabase().rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                retorno.add(montaEmpresa(cursor));
                cursor.moveToNext();
            }
            return retorno;
        }
        public Empresa montaEmpresa(Cursor cursor) {
            if (cursor.getCount() == 0) {
                return null;
            }
            Integer id_emp = cursor.getInt(cursor.getColumnIndex("id_emp"));
            String raz_soc = cursor.getString(cursor.getColumnIndex("raz_soc"));
            String cnpj = cursor.getString(cursor.getColumnIndex("cnpj"));
            String tipo_emp = cursor.getString(cursor.getColumnIndex("tipo_emp"));
            return new Empresa(id_emp, raz_soc, cnpj, tipo_emp);
        }
        /**
         * @param cnpj
         * @return
         */
        public Empresa findByCnpj(Integer cnpj) {
            String sql = "SELECT * FROM " + TABLE + " WHERE cnpj = ?";
            String[] selectionArgs = new String[] { "" + cnpj };
            Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);;
            cursor.moveToFirst();
            return montaEmpresa(cursor);
        }

    public List <Empresa> getAllNome(){
        List < Empresa > labels = new ArrayList <Empresa>();
        // Seleciona todas as consultas
        String selectQuery = "SELECT  * FROM" + TABLE;

        Cursor cursor = getReadableDatabase().rawQuery(selectQuery, null);

        // Loop através de todas as linhas e adicionando à lista
        if ( cursor.moveToFirst () ) {
            do {
                labels.add ( new Empresa ( cursor.getInt(0) , cursor.getString(1), cursor.getString(2), cursor.getString(3) ) );
            } while (cursor.moveToNext());
        }

        // Fecha conexão
        cursor.close();
        close();

        return labels;
    }

    }
