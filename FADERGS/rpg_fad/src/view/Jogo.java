package view;

import controller.ControleGame;
import dao.RankingDAO;
import model.Perguntas;
import model.Personagem;
import model.Ranking;

import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RankingDAO rankingDAO = new RankingDAO();
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            ControleGame controle = new ControleGame();

            System.out.println("===== BEM-VINDO AO RPG GÊNIO DAS EXATAS! =====");
            System.out.print("Digite o nome do personagem: ");
            String nome = scanner.nextLine();
            System.out.print("Digite seu nível em matemática: ");
            String nivelMatematica = scanner.nextLine();
            System.out.println();

            controle.criarPersonagem(nome, nivelMatematica);
            Personagem personagem = controle.getPersonagem();

            System.out.println("Personagem criado com sucesso!");
            System.out.println();
            System.out.println("Nome: " + personagem.getNome());
            System.out.println("Nível do domínio da matemática: " + personagem.getNivelMatematica());
            System.out.println("Nível inicial: " + personagem.getNivel());
            System.out.println("Vida inicial: " + personagem.getVida());
            System.out.println();

            while (controle.estaVivo()) {
                Perguntas pergunta = controle.novaPergunta();
                System.out.println("Pergunta: " + pergunta.getEnunciado());

                int resposta = -1;
                boolean respostaValida = false;

                while (!respostaValida) {
                    System.out.print("Sua resposta: ");
                    String input = scanner.nextLine().trim();

                    if (input.matches("-?\\d+")) {
                        resposta = Integer.parseInt(input);
                        respostaValida = true;
                    } else {
                        System.out.println("Entrada inválida. Digite apenas números inteiros!");
                    }
                }

                System.out.println();

                if (controle.verificarResposta(pergunta, resposta)) {
                    System.out.println("Resposta correta! Você subiu de nível!");
                    personagem.setNivel(personagem.getNivel() + 1);
                } else {
                    System.out.println("Errado! A resposta certa era: " + pergunta.getRespostaCorreta());
                    controle.aplicarDano(20);
                }

                System.out.println();
                System.out.println("Vida: " + personagem.getVida());
                System.out.println("Nível: " + personagem.getNivel());
                System.out.println("----------------------------------");
            }

            System.out.println("Fim de jogo! Seu personagem foi derrotado.");

            Ranking jogadorRanking = new Ranking(personagem.getNome(), personagem.getNivel(), personagem.getVida());
            rankingDAO.adicionarJogador(jogadorRanking);
            System.out.println("Seu desempenho foi salvo no ranking!");

            System.out.println();
            System.out.print("Deseja jogar novamente? (s/n): ");
            String respostaReinicio = scanner.nextLine();
            jogarNovamente = respostaReinicio.equalsIgnoreCase("s");
            System.out.println();
        }

        int opcao;
        do {
            System.out.println("\n===== MENU DO RANKING =====");
            System.out.println("1 - Ver ranking");
            System.out.println("2 - Atualizar nome de jogador");
            System.out.println("3 - Remover jogador do ranking");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    List<Ranking> jogadores = rankingDAO.listarJogadores();
                    System.out.println("\n--- RANKING DOS JOGADORES ---");
                    for (Ranking r : jogadores) {
                        System.out.println("ID: " + r.getId() + " | Nome: " + r.getNome() + " | Nível: " + r.getNivel() + " | Vida: " + r.getVida());
                    }
                    break;

                case 2:
                    System.out.print("Digite o ID do jogador para renomear: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    rankingDAO.atualizarNome(idAtualizar, novoNome);
                    System.out.println("Nome atualizado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o ID do jogador para remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    rankingDAO.removerJogador(idRemover);
                    System.out.println("Jogador removido com sucesso!");
                    break;

                case 0:
                    System.out.println("Saindo... Obrigado por jogar!");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
