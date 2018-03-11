package br.com.alura.androilayout.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.androilayout.adapter.ItemPacoteAdapter;
import br.com.alura.androilayout.model.Pacote;

public class MoedaUtil {


    public static String formatarValor(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return formatoBrasileiro.format(valor).replace("R$", "R$ ");


    }
}