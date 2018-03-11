package br.com.alura.androilayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo do Pacote");
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        Pacote pacote = (Pacote) extras.getSerializable("pacote");

        local.setText(pacote.getLocal());
        dias.setText(DiaUtil.formatarDias(pacote.getDias()));
        precoFinal.setText(MoedaUtil.formatarValor(pacote.getValor()));
        imagem.setImageDrawable(ImagemUtil.recuperarImagem(this, pacote.getImagem()));
        periodo.setText(DiaUtil.formataPeriodo(pacote.getDias()));

    }
}
