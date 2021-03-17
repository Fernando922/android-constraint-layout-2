package br.com.dipaulamobilesolutions.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.dipaulamobilesolutions.model.Pacote;
import br.com.dipaulamobilesolutions.myapplication.R;

import static br.com.dipaulamobilesolutions.utils.DiasUtil.formataEmTexto;
import static br.com.dipaulamobilesolutions.utils.MoedaUtil.formataParaBrasileiro;
import static br.com.dipaulamobilesolutions.utils.ResourcesUtil.retornaDrawable;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }


    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);


        Pacote pacote = pacotes.get(position);


        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.tv_preco);
        String moedaBrasileira = formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }


    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.tv_dias);
        int quantidadeDeDias = pacote.getDias();
        String txtDias = formataEmTexto(quantidadeDeDias);
        dias.setText(txtDias);
    }


    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.iv_city);
        Drawable drawableImagemPacote = retornaDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }


    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.tv_local);
        local.setText(pacote.getLocal());
    }
}
