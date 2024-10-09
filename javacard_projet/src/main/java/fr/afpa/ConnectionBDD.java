package fr.afpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionBDD {
    /**
     * URL de connexion
     */
    private static String url = "jdbc:postgresql://localhost:1117/contactDAO";
    /**
     * Nom du user
     */
    private static String user = "postgres";
    /**
     * Mot de passe du user
     */
    private static String passwd = "B@nLgU4qz*9?D~3n83";
    /**
     * Objet Connexionostgre
     */
    private static Connection connect;
    
    /**
     * Méthode qui va nous retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
     */
    public static Connection getInstance(){
        if(connect == null){
            try {
                System.out.println("Tentative de connexion");
                connect = DriverManager.getConnection(url, user, passwd);
                System.out.println("connectée");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
        return connect;    
    }    
}
