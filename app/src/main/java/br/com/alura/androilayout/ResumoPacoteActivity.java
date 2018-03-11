package br.com.alura.androilayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.androilayout.adapter.DiaUtil;
import br.com.alura.androilayout.adapter.ImagemUtil;
import br.com.alura.androilayout.model.Pacote;
import br.com.alura.androilayout.util.MoedaUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResumoPacoteActivity extends AppCompatActivity {

    @BindView(R.id.resumo_pacote_foto)
    ImageView imagem;

    @BindView(R.id.resumo_pacote_local)
    TextView local;

    @BindView(R.id.resumo_pacote_dias)
    TextView dias;

    @BindView(R.id.resumo_pacote_periodo)
    TextView periodo;

    @BindView(R.id.resumo_pacote_preco_final)
    TextView precoFinal;

    @BindView(R.id.resumo_pacote_realizar_pagamento)
    Button realizarPagamentoBtn;

    private Pacote pacoteSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo do Pacote");
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        pacoteSelecionado = (Pacote) extras.getSerializable("pacote");

        local.setText(pacoteSelecionado.getLocal());
        dias.setText(DiaUtil.formatarDias(pacoteSelecionado.getDias()));
        precoFinal.setText(MoedaUtil.formatarValor(pacoteSelecionado.getValor()));
        imagem.setImageDrawable(ImagemUtil.recuperarImagem(this, pacoteSelecionado.getImagem()));
        periodo.setText(DiaUtil.formataPeriodo(pacoteSelecionado.getDias()));

    }

    @OnClick(R.id.resumo_pacote_realizar_pagamento)
    public void onClickRealizarpagamento(){

        Intent irPagamento = new Intent(this, PagamentoActivity.class);
        irPagamento.putExtra("pacote", pacoteSelecionado);
        startActivity(irPagamento);
        finish();

    }

}
