package com.natasha.bloconotas;

public class Nota {
    private int id;
    private String titulo;
    private String txt;

    public Nota(int id, String titulo, String txt) {
        this.id = id;
        this.titulo = titulo;
        this.txt = txt;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getTxt() { return txt; }
}