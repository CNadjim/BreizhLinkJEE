package service;


import model.BreizhLink;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {

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


    public boolean verifyUser(User user){
        String requete = "SELECT PASSWORD FROM USER WHERE LOGIN=?";
        ResultSet resultats = null;
        String password = new String();
        if (user.isNull()) {
            System.out.println("User empty");
            return false;
        }
        try {
            PreparedStatement stmt = con.prepareStatement(requete);
            stmt.setString(1, user.getLogin());
            resultats = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultats.next()) {
                password = resultats.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(password.equals(user.getPassword())) return true;
        else return false;
    }

    public BreizhLink saveLink(BreizhLink breizhLink){
        return new BreizhLink();
    }








}
