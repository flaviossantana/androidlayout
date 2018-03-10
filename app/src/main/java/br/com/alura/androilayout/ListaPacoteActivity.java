package br.com.alura.androilayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.com.alura.androilayout.adapter.ItemPacoteAdapter;
import br.com.alura.androilayout.dao.PacoteDao;
import br.com.alura.androilayout.model.Pacote;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListaPacoteActivity extends AppCompatActivity {

    @BindView(R.id.lista_pacotes_listview)
    public ListView listaPacoteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacote);

        ButterKnife.bind(this);

        listaPacoteView.setAdapter(new ItemPacoteAdapter(this, new PacoteDao().lista()));

    }

    @OnItemClick(R.id.lista_pacotes_listview)
    public void onClikListaPacoteListView(int posicao){
        Pacote itemAtPosition = (Pacote) listaPacoteView.getItemAtPosition(posicao);
        itemAtPosition.getDias();
    }

}
