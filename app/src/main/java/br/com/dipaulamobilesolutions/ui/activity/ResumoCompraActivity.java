package br.com.dipaulamobilesolutions.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.dipaulamobilesolutions.model.Pacote;
import br.com.dipaulamobilesolutions.myapplication.R;
import br.com.dipaulamobilesolutions.utils.MoedaUtil;
import br.com.dipaulamobilesolutions.utils.ResourcesUtil;

import static br.com.dipaulamobilesolutions.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;
import static br.com.dipaulamobilesolutions.utils.DataUtil.periodoEmTexto;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);


        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatadaPacote = periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_nome_pacote);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawable = ResourcesUtil.retornaDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }
}