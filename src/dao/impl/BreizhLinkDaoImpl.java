package dao.impl;

import dao.BreizhLinkDao;
import exception.DAOException;
import model.BreizhLink;
import service.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BreizhLinkDaoImpl implements BreizhLinkDao {
    private ConnectionFactory connectionFactory;

    public BreizhLinkDaoImpl(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }
    private static final String SQL_INSERT = "INSERT INTO BREIZH_LINK (USER_LOGIN, URL, SHORT_URL, PSWD, VISITE, DATE_START, DATE_END, MAX_VISITE, SECURED) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public BreizhLink save( BreizhLink breizhLink ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = connectionFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,breizhLink.getUserLogin(), breizhLink.getUrl(), breizhLink.getShortUrl(),breizhLink.getPswd(),breizhLink.getVisite(),breizhLink.getDateStart(), breizhLink.getDateEnd(), breizhLink.getMaxVisite(), breizhLink.isSecured() );
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du breizhlink, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                breizhLink.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création du breizhlink, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
        return breizhLink;
    }


    private static final String SQL_UPDATE = "UPDATE BREIZH_LINK SET USER_LOGIN = ?, URL = ?, SHORT_URL = ?, PSWD = ?, VISITE = ?, DATE_START = ?, DATE_END = ?, MAX_VISITE = ?, SECURED = ? WHERE ID = ?";

    public void update( BreizhLink breizhLink ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = connectionFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true,breizhLink.getUserLogin(), breizhLink.getUrl(), breizhLink.getShortUrl(),breizhLink.getPswd(),breizhLink.getVisite(),breizhLink.getDateStart(), breizhLink.getDateEnd(), breizhLink.getMaxVisite(), breizhLink.isSecured(), breizhLink.getId() );
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de l'update du breizhlink, aucune ligne modifier dans la table." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion );
        }
    }

    private static final String SQL_SELECT_PAR_SHORT_URL = "SELECT ID, USER_LOGIN, URL, SHORT_URL, PSWD, VISITE, DATE_START, DATE_END, MAX_VISITE, SECURED FROM BREIZH_LINK WHERE SHORT_URL = ?";


    public BreizhLink findByShortUrl(String shortUrl ){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BreizhLink breizhLink = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = connectionFactory.getConnection();
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


    private static final String SQL_SELECT_PAR_USER_LOGIN = "SELECT ID, USER_LOGIN, URL, SHORT_URL, PSWD, VISITE, DATE_START, DATE_END, MAX_VISITE, SECURED FROM BREIZH_LINK WHERE USER_LOGIN = ?";

    public List<BreizhLink> findByUserLogin(String userLogin ){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BreizhLink> breizhLinks = new ArrayList<>();


        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = connectionFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_USER_LOGIN, false, userLogin );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while ( resultSet.next() ) {
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
        breizhLink.setVisite(resultSet.getLong( "VISITE" ));
        breizhLink.setDateStart(resultSet.getDate( "DATE_START" ) );
        breizhLink.setDateEnd(resultSet.getDate( "DATE_END" ) );
        breizhLink.setMaxVisite(resultSet.getLong( "MAX_VISITE" ));
        breizhLink.setSecured(resultSet.getBoolean( "SECURED" ));
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
