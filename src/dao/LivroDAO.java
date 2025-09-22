package dao;

import dominio.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    private Connection conexao;

    public LivroDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public boolean inserir(Livro livro) {
        String sqlInsert = "INSERT INTO book( nome, editora, ano) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInsert)) {
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getEditora());
            stmt.setDate(3, livro.getAno());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Livro livro) {
        String sqlUpdate = "UPDATE book SET nome=?, editora=?, ano=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlUpdate)) {
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getEditora());
            stmt.setDate(3, livro.getAno());
            stmt.setInt(4, livro.getId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(int id) {
        String sqlDelete = "DELETE FROM book WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlDelete)) {
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
