package dominio;

import java.sql.Date;

public class Livro {
    private int id;
    private String nome;
    private String editora;
    private Date ano;

    public Livro(int id, String nome, String editora, Date ano) {
        this.id = id;
        this.nome = nome;
        this.editora = editora;
        this.ano = ano;
    }

    public Livro () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", editora='" + editora + '\'' +
                ", ano=" + ano +
                '}';
    }
}
