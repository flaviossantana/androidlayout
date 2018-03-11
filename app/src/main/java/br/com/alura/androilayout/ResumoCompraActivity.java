package br.com.alura.androilayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.alura.androilayout.adapter.DiaUtil;
import br.com.alura.androilayout.adapter.ImagemUtil;
import br.com.alura.androilayout.model.Pacote;
import br.com.alura.androilayout.util.MoedaUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ResumoCompraActivity extends AppCompatActivity {

    @BindView(R.id.resumo_compra_imagem)
    ImageView imagem;

    @BindView(R.id.resumo_compra_local)
    TextView local;

    @BindView(R.id.resumo_compra_periodo)
    TextView periodo;

    @BindView(R.id.resumo_compra_valor)
    TextView valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle("Resumo Compra");
        ButterKnife.bind(this);

        Pacote pacote = (Pacote) getIntent().getSerializableExtra("pacote");

        local.setText(pacote.getLocal());
        imagem.setImageDrawable(ImagemUtil.recuperarImagem(this, pacote.getImagem()));
        periodo.setText(DiaUtil.formataPeriodo(pacote.getDias()));
        valor.setText(MoedaUtil.formatarValor(pacote.getValor()));

    }
}
