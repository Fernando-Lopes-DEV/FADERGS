package model;

public class Ranking {
    private int id;
    private String nome;
    private int nivel;
    private int vida;

    // Construtor para listar do banco (com id)
    public Ranking(int id, String nome, int nivel, int vida) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
    }

    // Construtor para inserir (sem id)
    public Ranking(String nome, int nivel, int vida) {
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
    }

    // Getters e setters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getNivel() {
        return nivel;
    }
    public int getVida() {
        return vida;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
}
