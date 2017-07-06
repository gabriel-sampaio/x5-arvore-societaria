package com.arvore.gabriel.arvore;

/**
 * Created by gabriel on 05/07/17.
 */

public class Investimento {

    private Integer id_investimento;
    private Integer qtidade_inv;
    private Integer id_investidora;
    private Integer id_investida;

    public Investimento(Integer id_investimento, Integer qtidade_inv, Integer id_investidora, Integer id_investida) {
        this.id_investimento = id_investimento;
        this.qtidade_inv = qtidade_inv;
        this.id_investidora = id_investidora;
        this.id_investida = id_investida;;
    }

    public Integer getId_investimento() {
        return id_investimento;
    }

    public void setId_investimento(Integer id_investimento) {
        this.id_investimento = id_investimento;
    }

    public Integer getQtidade_inv() {
        return qtidade_inv;
    }

    public void setQtidade_inv(Integer qtidade_inv) {
        this.qtidade_inv = qtidade_inv;
    }

    public Integer getId_investidora() {
        return id_investidora;
    }

    public void setId_investidora(Integer id_investidora) {
        this.id_investidora = id_investidora;
    }

    public Integer getId_investida() {
        return id_investida;
    }

    public void setId_investida(Integer id_investida) {
        this.id_investida = id_investida;
    }
}



