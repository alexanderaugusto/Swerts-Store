package br.inatel.swertsstore.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    private Connection con; // objeto responsável pela conexão com o servidor do banco de dados

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    private String database = "swerts_db";
    private String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private String user = "root";
    private String password = "root";

    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {

            System.out.println("Erro: " + ex.getMessage());

        }
    }
}
