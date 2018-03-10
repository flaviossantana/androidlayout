package br.com.alura.androilayout.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

import br.com.alura.androilayout.R;
import br.com.alura.androilayout.model.Pacote;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ItemPacoteAdapter extends BaseAdapter {

    private final Context context;
    private final List<Pacote> listaPacotes;

    public ItemPacoteAdapter(Context context, List<Pacote> listaPacotes) {
        this.context = context;
        this.listaPacotes = listaPacotes;
    }

    @Override
    public int getCount() {
        return this.listaPacotes.size();
    }

    @Override
    public Pacote getItem(int index) {
        return this.listaPacotes.get(index);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View view, ViewGroup paarent) {
        View itemPacoteView = LayoutInflater.from(context).inflate(R.layout.item_pacote, paarent, false);
        Pacote pacote = getItem(index);

        PacoteHolder pacoteHolder = new PacoteHolder(itemPacoteView);
        pacoteHolder.local.setText(pacote.getLocal());
        String dias = pacote.getDias() >= 1 ? " Dia" : " Dias";
        pacoteHolder.dias.setText(pacote.getDias() + dias);

        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileiro
                .format(pacote.getValor())
                .replace("R$", "R$ ");

        pacoteHolder.valor.setText(moedaBrasileira);

        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawable = resources.getDrawable(identifier);
        pacoteHolder.imagem.setImageDrawable(drawable);



        return itemPacoteView;
    }


    static class PacoteHolder {

        @BindView(R.id.item_local)
        TextView local;

        @BindView(R.id.item_dias)
        TextView dias;

        @BindView(R.id.item_valor)
        TextView valor;

        @BindView(R.id.item_foto)
        ImageView imagem;

        public PacoteHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

}
