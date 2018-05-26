package service;
import java.sql.*;

public class ConnectionFactory {

    private Connection con;

    public Connection connect(String login,String pass){
        this.con = null;
        // chargement du pilote
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //connection a la base de données
        try {
            String DBurl = "jdbc:mysql://localhost:3306/mydb";
            this.con = DriverManager.getConnection(DBurl,login,pass);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return con;
    }

    public Connection getConnection(){
        this.con = null;
        // chargement du pilote
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //connection a la base de données
        try {
            String DBurl = "jdbc:mysql://localhost:3306/mydb";
            this.con = DriverManager.getConnection(DBurl,"root","root");

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return con;
    }










}
