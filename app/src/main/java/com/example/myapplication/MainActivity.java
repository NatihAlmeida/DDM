package com.example.myapplication;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //visual na vertical
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("Anos da Noite", "1972"));
        filmes.add(new Filme("Sonic", "2026"));
        filmes.add(new Filme("Hobbit", "2000"));
        filmes.add(new Filme("João e Maria", "2005"));

        //conexao da lista ao adapter e conexao do adapter ao recyclerview
        FilmeAdapter adapter = new FilmeAdapter(filmes);
        recyclerView.setAdapter(adapter);
    }
}