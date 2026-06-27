package com.natasha.bloconotas;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ControladorNota controller;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ControladorNota(this);
        listView = findViewById(R.id.listView);

        // Teste: Inserir se estiver vazio para não ficar tela branca
        Cursor c = controller.listar();
        if (c.getCount() == 0) {
            controller.cadastrarNota(new Nota(0, "Primeira Nota", "Texto de teste"));
        }

        exibirNotas();
    }

    private void exibirNotas() {
        Cursor cursor = controller.listar();
        String[] de = {"titulo"};
        int[] para = {android.R.id.text1};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, android.R.layout.simple_list_item_1, cursor, de, para, 0);
        listView.setAdapter(adapter);
    }
}