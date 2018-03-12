package br.com.alura.androilayout.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.androilayout.R;
import br.com.alura.androilayout.model.Pacote;
import br.com.alura.androilayout.util.DiaUtil;
import br.com.alura.androilayout.util.ImagemUtil;
import br.com.alura.androilayout.util.MoedaUtil;
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
        formatarDias(pacote, pacoteHolder);
        formatarValor(pacote, pacoteHolder);
        recuperarImagem(pacote, pacoteHolder);

        return itemPacoteView;
    }

    private void recuperarImagem(Pacote pacote, PacoteHolder pacoteHolder) {
        Drawable drawable = ImagemUtil.recuperarImagem(context, pacote.getImagem());
        pacoteHolder.imagem.setImageDrawable(drawable);
    }

    private void formatarValor(Pacote pacote, PacoteHolder pacoteHolder) {
        String valor = MoedaUtil.formatarValor(pacote.getValor());
        pacoteHolder.valor.setText(valor);
    }

    private void formatarDias(Pacote pacote, PacoteHolder pacoteHolder) {
        String dias = DiaUtil.formatarDias(pacote.getDias());
        pacoteHolder.dias.setText(dias);
    }

    public Context getContext() {
        return context;
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
