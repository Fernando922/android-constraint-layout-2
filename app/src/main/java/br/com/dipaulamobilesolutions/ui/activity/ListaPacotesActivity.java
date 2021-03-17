package br.com.dipaulamobilesolutions.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.dipaulamobilesolutions.dao.PacoteDAO;
import br.com.dipaulamobilesolutions.model.Pacote;
import br.com.dipaulamobilesolutions.myapplication.R;
import br.com.dipaulamobilesolutions.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APP_BAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lv_cities);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }


}