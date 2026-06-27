package com.natasha.bloconotas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOnota {
    private SQLiteDatabase banco;

    public DAOnota(Context context) {
        banco = context.openOrCreateDatabase("bancoNotas", Context.MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS notas (_id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, txt TEXT)");
    }

    public void insereNota(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.getTitulo());
        cv.put("txt", nota.getTxt());
        banco.insert("notas", null, cv);
    }

    public Cursor getListaNotas() {
        return banco.rawQuery("SELECT _id AS _id, titulo FROM notas", null);
    }
}