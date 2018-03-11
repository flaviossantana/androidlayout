package br.com.alura.androilayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.alura.androilayout.model.Pacote;
import br.com.alura.androilayout.util.MoedaUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PagamentoActivity extends AppCompatActivity {

    @BindView(R.id.pagamento_valor_compra)
    TextView valorCompra;

    @BindView(R.id.pagamento_nmumero_cartao)
    EditText numeroCartao;

    @BindView(R.id.pagamento_mes)
    EditText mesCartao;

    @BindView(R.id.pagamento_ano)
    EditText anoCartao;

    @BindView(R.id.pagamento_cvc)
    EditText cvcCartao;

    @BindView(R.id.pagamento_nome_cartao)
    EditText nomeNoCartao;

    @BindView(R.id.pagamento_finalizar_compra)
    Button finalizarCompra;

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento do Pacote");
        ButterKnife.bind(this);

        pacote = (Pacote) getIntent().getSerializableExtra("pacote");
        valorCompra.setText(MoedaUtil.formatarValor(pacote.getValor()));

    }

    @OnClick(R.id.pagamento_finalizar_compra)
    public void onClickFinalizaraCompra(){

        Intent irResumoCompra = new Intent(this, ResumoCompraActivity.class);
        irResumoCompra.putExtra("pacote", pacote);
        startActivity(irResumoCompra);

    }

}
