package model;

public class Personagem {
    private String nome;
    private int nivel;
    private String nivelMatematica;
    private int vida;

    public String getNome() {
        return nome;

    }
    public int getNivel() {
        return nivel;

    }
    public String getNivelMatematica() {
        return nivelMatematica;
    }
    public int getVida(){
        return vida;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setNivelMatematica(String nivelMatematica) {
        this.nivelMatematica = nivelMatematica;

    }

    public void setVida(int vida) {
        this.vida = vida;

    }

    public Personagem(String nome, String nivelMatematica) {
        this.nome = nome;
        this.nivel = 1;
        this.nivelMatematica = nivelMatematica;
        this.vida = 100;
    }
}
