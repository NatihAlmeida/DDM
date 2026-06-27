package com.natasha.bloconotas;

import android.content.Context;
import android.database.Cursor;

public class ControladorNota {
    private DAOnota dao;

    public ControladorNota(Context context) {
        this.dao = new DAOnota(context);
    }

    public void cadastrarNota(Nota nota) {
        dao.insereNota(nota);
    }

    public Cursor listar() {
        return dao.getListaNotas();
    }
}