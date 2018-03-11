package br.com.alura.androilayout.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.alura.androilayout.model.Pacote;

public class DiaUtil {

    public static String formatarDias(int qtdDias) {
        String dias = qtdDias >= 1 ? " Dia" : " Dias";
        return qtdDias + dias;
    }

    public static String formataPeriodo(int qtdDias){
        Calendar ida = Calendar.getInstance();
        Calendar volta = Calendar.getInstance();
        volta.add(Calendar.DATE, qtdDias);
        return formataDiaMes(ida.getTime()) + " - " + formataDiaMes(volta.getTime()) + " de " + volta.get(Calendar.YEAR);
    }

    public static String formataDiaMes(Date data){
        SimpleDateFormat formatoDiaMes = new SimpleDateFormat("dd/MM");
        return formatoDiaMes.format(data);
    }
}