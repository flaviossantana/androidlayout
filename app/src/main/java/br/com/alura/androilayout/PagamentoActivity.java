package br.com.alura.androilayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Or;
import com.mobsandgeeks.saripaar.annotation.Order;

import java.util.Arrays;
import java.util.List;

import br.com.alura.androilayout.model.Pacote;
import br.com.alura.androilayout.util.MoedaUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PagamentoActivity extends AppCompatActivity implements Validator.ValidationListener {

    private Pacote pacote;

    private Validator validator;

    @BindView(R.id.pagamento_valor_compra)
    public TextView valorCompra;

    @Order(1)
    @NotEmpty(message = "Informe o número do cartão.")
    @BindView(R.id.pagamento_nmumero_cartao)
    EditText numeroCartao;

    @Order(2)
    @NotEmpty(message = "Informe o mês do vencimento do cartão.", sequence = 1)
    @BindView(R.id.pagamento_mes)
    EditText mesCartao;

    @Order(3)
    @NotEmpty(message = "Informe o ano do vencimento do cartão.")
    @BindView(R.id.pagamento_ano)
    EditText anoCartao;

    @Order(4)
    @NotEmpty(message = "Informe o código de verificação do cartão.")
    @BindView(R.id.pagamento_cvc)
    EditText cvcCartao;

    @Order(5)
    @NotEmpty(message = "Informe o nome que esta no cartão.")
    @BindView(R.id.pagamento_nome_cartao)
    EditText nomeNoCartao;

    @BindView(R.id.pagamento_finalizar_compra)
    Button finalizarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento do Pacote");

        ButterKnife.bind(this);
        validator = new Validator(this);
        validator.setValidationListener(this);

        pacote = (Pacote) getIntent().getSerializableExtra("pacote");
        valorCompra.setText(MoedaUtil.formatarValor(pacote.getValor()));

    }

    @OnClick(R.id.pagamento_finalizar_compra)
    public void onClickFinalizaraCompra(){
        validator.validate();
    }

    private void irParaResumoCompra() {
        Intent irResumoCompra = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        irResumoCompra.putExtra("pacote", pacote);
        startActivity(irResumoCompra);
        finish();
    }

    @Override
    public void onValidationSucceeded() {
        irParaResumoCompra();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        ValidationError erro = errors.get(0);
        for (ValidationError error :Arrays.asList(erro)) {
            View view = error.getView();
            switch (view.getId()){
                case R.id.pagamento_nmumero_cartao :
                    numeroCartao.setError(error.getCollatedErrorMessage(this));
                    break;
                case R.id.pagamento_mes :
                    mesCartao.setError(error.getCollatedErrorMessage(this));
                    break;
                case R.id.pagamento_ano :
                    anoCartao.setError(error.getCollatedErrorMessage(this));
                    break;
                case R.id.pagamento_cvc :
                    cvcCartao.setError(error.getCollatedErrorMessage(this));
                    break;
                case R.id.pagamento_nome_cartao :
                    nomeNoCartao.setError(error.getCollatedErrorMessage(this));
                    break;
            }

            view.requestFocus();

        }

    }
}
