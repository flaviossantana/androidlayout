package br.com.alura.androilayout.adapter;

import br.com.alura.androilayout.model.Pacote;

public class DiaUtil {

    public static String formatarDias(int qtdDias) {
        String dias = qtdDias >= 1 ? " Dia" : " Dias";
        return qtdDias + dias;
    }
}