package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {

    private final List<Filme> listaFilmes;

    public FilmeAdapter(List<Filme> filmes) { this.listaFilmes = filmes; }

    @NonNull
    @Override
    // Converte o arquivo XML do item em um objeto View
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.tvTitulo.setText(filme.getTitulo());
        holder.tvAno.setText(filme.getAno());
    }

    @Override
    public int getItemCount() { return listaFilmes.size(); }

    static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvAno;
        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            //localizacao de componentes do layout do filme
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvAno = itemView.findViewById(R.id.tvAno);
        }
    }
}