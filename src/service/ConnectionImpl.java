package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionImpl {

    public static Connection getConnection() {
        String URL = "jdbc:mysql://localhost:3306/projetopessoal";
        String login = "root";
        String senha = "040704Pc";

        try {
            return DriverManager.getConnection(URL, login, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
