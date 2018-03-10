package br.com.alura.androilayout.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by f1avi on 09/03/2018.
 */

public class Pacote implements Serializable {

    private String local;
    private int dias;
    private BigDecimal valor;
    private String imagem;

    public Pacote() {
        super();
    }

    public Pacote(String local, String imagem, int dias, BigDecimal valor) {
        this.local = local;
        this.dias = dias;
        this.valor = valor;
        this.imagem = imagem;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
