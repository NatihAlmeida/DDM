package com.example.myapplication;

public class Filme {
    private String titulo;
    private String ano;

    public Filme(String titulo, String ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
    public String getAno() { return ano; }
}
