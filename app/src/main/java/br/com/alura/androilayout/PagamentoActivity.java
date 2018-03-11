package br.com.alura.androilayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.alura.androilayout.model.Pacote;
import br.com.alura.androilayout.util.MoedaUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PagamentoActivity extends AppCompatActivity {

    @BindView(R.id.pagamento_valor_compra)
    TextView valorCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento do Pacote");
        ButterKnife.bind(this);

        Pacote pacote = (Pacote) getIntent().getSerializableExtra("pacote");
        valorCompra.setText(MoedaUtil.formatarValor(pacote.getValor()));

    }
}
