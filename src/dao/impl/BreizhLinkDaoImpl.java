package dao.impl;

import dao.BreizhLinkDao;
import exception.DAOException;
import model.BreizhLink;
import service.DbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BreizhLinkDaoImpl implements BreizhLinkDao {
    private DbConnect dbConnect;

    public BreizhLinkDaoImpl(DbConnect dbConnect){
        this.dbConnect = dbConnect;
    }

    private static final String SQL_SELECT_PAR_SHORT_URL = "SELECT ID,USER_LOGIN, URL, SHORT_URL, PSWD FROM BREIZH_LINK WHERE SHORT_URL = ?";


    public boolean save ( BreizhLink breizhLink ){
        return false;
    }

    public BreizhLink findByShortUrl(String shortUrl ){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BreizhLink breizhLink = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = dbConnect.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_SHORT_URL, false, shortUrl );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                breizhLink = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return breizhLink;
    }


    private static final String SQL_SELECT_PAR_USER_LOGIN = "SELECT ID,USER_LOGIN, URL, SHORT_URL, PSWD FROM BREIZH_LINK WHERE USER_LOGIN = ?";

    public List<BreizhLink> findByUserLogin(String userLogin ){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BreizhLink> breizhLinks = new ArrayList<>();


        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = dbConnect.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_USER_LOGIN, false, userLogin );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while ( resultSet.next() ) {
                System.out.println(resultSet.toString());
                breizhLinks.add(map( resultSet ));
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return breizhLinks;
    }


    public static PreparedStatement initialisationRequetePreparee(Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }


    private static BreizhLink map( ResultSet resultSet ) throws SQLException {
        BreizhLink breizhLink = new BreizhLink();
        breizhLink.setId( resultSet.getLong( "ID" ) );
        breizhLink.setUserLogin( resultSet.getString( "USER_LOGIN" ) );
        breizhLink.setUrl( resultSet.getString( "URL" ) );
        breizhLink.setShortUrl( resultSet.getString( "SHORT_URL" ) );
        breizhLink.setPswd( resultSet.getString( "PSWD" ) );
        return breizhLink;
    }

    /* Fermeture silencieuse du resultset */
    public static void fermetureSilencieuse( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
            }
        }
    }

    /* Fermeture silencieuse du statement */
    public static void fermetureSilencieuse( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
            }
        }
    }

    /* Fermeture silencieuse de la connexion */
    public static void fermetureSilencieuse( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
            }
        }
    }

    /* Fermetures silencieuses du statement et de la connexion */
    public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );
    }

    /* Fermetures silencieuses du resultset, du statement et de la connexion */
    public static void fermeturesSilencieuses( ResultSet resultSet, Statement statement, Connection connexion ) {
        fermetureSilencieuse( resultSet );
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );
    }


}
