package dao;

import model.Ranking;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankingDAO {

    private String url = "jdbc:mysql://localhost:3306/exatas";
    private String user = "root";
    private String password = "";

    // Carrega o driver JDBC - opcional, mas ajuda a garantir
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do MySQL não encontrado!");
            e.printStackTrace();
        }
    }

    public void adicionarJogador(Ranking jogador) {
        String sql = "INSERT INTO ranking (nome, nivel, vida) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jogador.getNome());
            stmt.setInt(2, jogador.getNivel());
            stmt.setInt(3, jogador.getVida());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar jogador no banco: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Ranking> listarJogadores() {
        List<Ranking> lista = new ArrayList<>();
        String sql = "SELECT * FROM ranking ORDER BY nivel DESC";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ranking r = new Ranking(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("nivel"),
                        rs.getInt("vida")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar jogadores: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizarNome(int id, String novoNome) {
        String sql = "UPDATE ranking SET nome = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas == 0) {
                System.out.println("Nenhum jogador encontrado com o ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar nome: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void removerJogador(int id) {
        String sql = "DELETE FROM ranking WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas == 0) {
                System.out.println("Nenhum jogador encontrado com o ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover jogador: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
