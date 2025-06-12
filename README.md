# FADERGS
# Fadergs Projeto A3 - CRUD em Java

## Descrição
Projeto desenvolvido para a disciplina de programação na Fadergs, implementando um sistema CRUD (Create, Read, Update, Delete) em Java. O tema do projeto é um quiz de matemática com criação de personagem e ranking dos jogadores.

## Funcionalidades
- Criação de personagem com nome e nível de matemática.
- Geração de perguntas matemáticas aleatórias.
- Verificação das respostas e atualização do nível e vida do personagem.
- Sistema de ranking que armazena resultados no banco de dados.
- Operações CRUD para gerenciar o ranking:
  - Listar jogadores
  - Atualizar nome do jogador
  - Remover jogador

## Tecnologias Utilizadas
- Java (Terminal)
- JDBC para conexão com banco MySQL
- MySQL (banco de dados)

## Como Executar
1. Configure o banco de dados MySQL com a tabela `ranking`.
2. Ajuste as credenciais no arquivo `RankingDAO.java`.
3. Compile e execute a classe `view.Jogo`.

## Estrutura do Projeto
- `model` — Classes de domínio (Personagem, Perguntas, Ranking)
- `controller` — Lógica do jogo (ControleGame)
- `dao` — Acesso a dados (RankingDAO)
- `view` — Interface com o usuário (Jogo)

## Autor
Fernando Lopes

## Licença
Este projeto é open-source e pode ser usado para fins acadêmicos.


