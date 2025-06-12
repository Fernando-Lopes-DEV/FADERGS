package controller;
import model.Perguntas;
import model.Personagem;

public class ControleGame {

    private Personagem personagem;

    public void criarPersonagem(String nome, String nivelMatematica) {
        personagem = new Personagem(nome,nivelMatematica);
    }

    public Personagem getPersonagem() {
        return personagem;
    }
    public Perguntas novaPergunta() {
        return new Perguntas();

    }
    public boolean verificarResposta(Perguntas pergunta, int resposta) {
        return resposta == pergunta.getRespostaCorreta();
    }

    public void aplicarDano(int dano) {
        personagem.setVida(personagem.getVida() - dano);
    }

    public boolean estaVivo() {
        return personagem.getVida() > 0;
    }
}
