package br.com.alura.androilayout.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.alura.androilayout.model.Pacote;

public class ImagemUtil {
    private final ItemPacoteAdapter itemPacoteAdapter;

    public ImagemUtil(ItemPacoteAdapter itemPacoteAdapter) {
        this.itemPacoteAdapter = itemPacoteAdapter;
    }

    public static Drawable recuperarImagem(Context context, String imagem) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(imagem, "drawable", context.getPackageName());
        return resources.getDrawable(identifier);
    }
}