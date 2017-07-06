package com.arvore.gabriel.arvore;

/**
 * Created by gabriel on 03/07/17.
 */

public class Empresa {
    private Integer id_emp;
    private String raz_soc;



    private String cnpj;

    private String tipo_emp;

    /**
     * @param id_emp
     * @param raz_soc
     * @param cnpj
     * @param tipo_emp
     */
    public Empresa(Integer id_emp, String raz_soc, String cnpj, String tipo_emp) {
        this.id_emp = id_emp;
        this.raz_soc= raz_soc;
        this.cnpj= cnpj;
    }

    public Integer getId_emp() {
        return id_emp;
    }

    public void setId_emp(Integer id_emp) {
        this.id_emp = id_emp;
    }

    public String getRaz_soc() {
        return raz_soc;
    }

    public void setRaz_soc(String raz_soc) {
        this.raz_soc = raz_soc;
    }

    public String getCnpj() {return cnpj;   }

    public void setCnpj(String cnpj) { this.cnpj = cnpj;  }

    public String getTipo_emp() { return tipo_emp;  }

    public void setTipo_emp(String tipo_emp) {  this.tipo_emp = tipo_emp;   }

    @Override
    public String toString() {
        return raz_soc;
    }

    public String toString2() {
        return Integer.toString(id_emp);
    }




}
