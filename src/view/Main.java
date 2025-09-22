package view;

import dao.LivroDAO;
import dominio.Livro;
import service.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            LivroDAO livroDAO = new LivroDAO(conn);
            Scanner entrada = new Scanner(System.in);

            System.out.println("\n====Registro de Filmes====");
            System.out.println("Digite o nome do filme:");
            String nome1 = entrada.nextLine();
            System.out.println("Digite a editora do livro:");
            String e1 = entrada.nextLine();
            System.out.println("Digite o ano de lançamento do livro:");
            String data = entrada.nextLine();
            Date ano1 = Date.valueOf(data);

            Livro l1 = new Livro();
            l1.setNome(nome1);
            l1.setEditora(e1);
            l1.setAno(ano1);

            livroDAO.inserir(l1);

            System.out.print("Digite a ID do livro que deseja alterar: ");
            int idAlterar = entrada.nextInt();
            entrada.nextLine(); // Consome a quebra de linha

            System.out.print("Digite o novo nome do livro: ");
            String nomeAlterar = entrada.nextLine();
            System.out.print("Digite a nova editora: ");
            String editoraAlterar = entrada.nextLine();
            System.out.print("Digite o novo ano (AAAA-MM-DD): ");
            String dataAlterar = entrada.nextLine();
            Date dataAlterada = Date.valueOf(dataAlterar);

            Livro l2 = new Livro();
            l2.setId(idAlterar);
            l2.setNome(nomeAlterar);
            l2.setEditora(editoraAlterar);
            l2.setAno(dataAlterada);

            boolean sucesso = livroDAO.alterar(l2);

            if (sucesso) {
                System.out.println("✅ Livro alterado com sucesso!");
            } else {
                System.out.println("❌ Erro ao alterar o livro. Verifique se a ID existe.");
            }

            System.out.println("\n==== Removendo livro ====");
            System.out.print("Digite a ID do livro que deseja remover: ");
            int idRemover = entrada.nextInt();
            entrada.nextLine();

            livroDAO.deletar(idRemover);

            boolean sucessoDeletar = livroDAO.deletar(idRemover);

            if (sucessoDeletar) {
                System.out.println("✅ Livro deletado com sucesso!");
            } else {
                System.out.println("❌ Erro ao deletar o livro. Verifique se a ID existe.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro durante a operação no banco de dados.");
            e.printStackTrace();
        }


    }
}
