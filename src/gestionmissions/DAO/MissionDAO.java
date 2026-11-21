package gestionmissions.DAO;


import gestionmissions.Connexion.ConnexionBDD;
import gestionmissions.Metier.Mission;
import gestionmissions.Metier.Priorite;
import gestionmissions.Metier.Statut;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Connection;
import java.sql.Statement;

public class MissionDAO {
       /*public ArrayList<Mission> lister() throws SQLException{
        ArrayList<Mission> missions = new ArrayList <Mission>();
        String sql = "SELECT * FROM  mission ORDER BY date_debut, titre";
        
        try( Connection connexion = ConnexionBDD.obtenirConnexion();
            PreparedStatement requete = connexion.prepareStatement(sql);
            ResultSet resultat = requete.executeQuery())
        {
            while (resultat.next()){
              Mission mission = construireMission(resultat);
              missions.add(mission);
            }
        }
         return missions;
    }*/
    
    
    public ArrayList<Mission> lister2() throws SQLException {
        String sql = "SELECT * FROM mission ORDER BY date_debut, titre";
       
                Connection connexion = ConnexionBDD.obtenirConnexion();
             Statement transmission=connexion.createStatement();
             ResultSet lesResultats=transmission.executeQuery(sql);
             
             ArrayList<Mission> lesMissions=new ArrayList<Mission>();
             //il faut se positionner sur la première ligne d'enregistrement au debut
             //sinon ce sont les champs qu'on tente de recupérer id, titre, description....
             Mission uneMission;
             while(lesResultats.next()){
            uneMission=new Mission( 
                    lesResultats.getString("titre"),
                    lesResultats.getString("description"),lesResultats.getDate("date_debut").toLocalDate(),
                    lesResultats.getDate("date_fin").toLocalDate(), 
                    Statut.valueOf(lesResultats.getString("statut")),
                    Priorite.valueOf(lesResultats.getString("priorite")),
                    lesResultats.getDouble("budget"));
            lesMissions.add(uneMission);
            uneMission.setId(lesResultats.getInt("id"));
             }
        return lesMissions;
        
    }
    
    public ArrayList<Mission> listerPreparer() throws SQLException {       
            String sql = "SELECT * FROM mission ORDER BY date_debut, titre";
            ArrayList<Mission> lesMissions = new ArrayList<Mission>();
            Connection connexion = ConnexionBDD.obtenirConnexion();
            PreparedStatement requete = connexion.prepareStatement(sql);
            ResultSet lesResultats = requete.executeQuery();           
            Mission uneMission;
            while(lesResultats.next()){
                uneMission=new Mission(                       
                        lesResultats.getString("titre"),
                        lesResultats.getString("description"),lesResultats.getDate("date_debut").toLocalDate(),
                        lesResultats.getDate("date_fin").toLocalDate(),
                        Statut.valueOf(lesResultats.getString("statut")),
                        Priorite.valueOf(lesResultats.getString("priorite")),
                        lesResultats.getDouble("budget"));
                lesMissions.add(uneMission);
                
            }         
            return lesMissions;
    }


    public int ajouter(Mission mission) throws SQLException{
        String sql = "Insert into Mission (titre,description,date_debut,date_fin, statut, priorite,budget) VALUES (?,?,?,?,?,?,?)";
        int rep ;
        Connection connexion = ConnexionBDD.obtenirConnexion();
        PreparedStatement requete = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
        requete.setString(1, mission.getTitre());
        requete.setString(2, mission.getDescription());
        requete.setDate(3,Date.valueOf(mission.getDateDebut()));  
        requete.setDate(4,Date.valueOf(mission.getDateFin()));
        requete.setString(5,mission.getStatut().name());
        requete.setString(6,mission.getPriorite().name());
        requete.setDouble(7,mission.getBudget());
        rep=requete.executeUpdate();
        
        ResultSet cles = requete.getGeneratedKeys();
        if (cles.next()){
            mission.setId(cles.getInt(1));
        }
        
        return rep;
    }
    
    public boolean modifier(Mission mission)throws SQLException{
        String sql = "Update Mission SET titre = ?, description = ?, date_debut = ?, date_fin = ?, statut = ?, priorite =?, budget =? WHERE id = ?";
        
        int rep;
        boolean reponse;
        try (
        Connection connexion = ConnexionBDD.obtenirConnexion();
        PreparedStatement requete = connexion.prepareStatement(sql)){
           
        requete.setString(1, mission.getTitre());
        requete.setString(2, mission.getDescription());
        requete.setDate(3,Date.valueOf(mission.getDateDebut()));  
        requete.setDate(4,Date.valueOf(mission.getDateFin()));
        requete.setString(5,mission.getStatut().name());
        requete.setString(6,mission.getPriorite().name());
        requete.setDouble(7,mission.getBudget());
        requete.setInt(8, mission.getId());
        rep=requete.executeUpdate();
        }
        if (rep==1){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean supprimer(int id)throws SQLException{
        String sql = "DELETE FROM mission WHERE id = ? ";
        int rep;
        try(
            Connection connexion = ConnexionBDD.obtenirConnexion();
            PreparedStatement requete = connexion.prepareStatement(sql)){
            requete.setInt(1, id);
            rep=requete.executeUpdate();
        }
        if (rep==1){
            return true;
        }
        else {
            return false;
        }
    }
    
     public Mission trouverParId(int id) throws SQLException {
        String sql = "SELECT * FROM mission WHERE id = ?";

        try (Connection connexion = ConnexionBDD.obtenirConnexion(); PreparedStatement requete = connexion.prepareStatement(sql)) {
            requete.setInt(1, id);
            try (
                    ResultSet resultat
                    = requete.executeQuery()) {
                if (resultat.next()) {
                    return construireMission(resultat);
                }

                return null;
            }
        }
    }
 
    private Mission construireMission(ResultSet resultat) throws SQLException {
        return new Mission(
                resultat.getString("titre"),
                resultat.getString("description"),
                resultat.getDate("date_debut").toLocalDate(),
                resultat.getDate("date_fin").toLocalDate(),
                Statut.valueOf(resultat.getString("statut")),
                Priorite.valueOf(resultat.getString("priorite")),
                resultat.getDouble("budget")
        );
    }
    
}
