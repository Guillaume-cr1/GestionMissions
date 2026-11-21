package gestionmissions;

import java.sql.SQLException;
import java.sql.Connection;
import gestionmissions.Connexion.ConnexionBDD;
import gestionmissions.DAO.MissionDAO;
import gestionmissions.Metier.Mission;
import gestionmissions.Metier.Priorite;
import gestionmissions.Metier.Statut;
import  java.util.ArrayList;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author guillaume.crampe
 */
public class GestionMissions {

    public static void main(String[] args) throws SQLException {
        try(Connection connection = ConnexionBDD.obtenirConnexion()){
            System.out.println("Connexion reussie");
            
               ArrayList<Mission> lesMissions = new ArrayList<Mission>();
               MissionDAO uneMissionDAO = new MissionDAO();
               lesMissions=uneMissionDAO.listerPreparer();
                
        for (int i=0;i<lesMissions.size();i++){
            System.out.println(lesMissions.get(i).toString());
        } 
        
       // Mission uneMission=new Mission ("test","test","2026-11-12","2026-12-12");
        Mission missionTest = new Mission(
            "Mission de test DAO",
            "Mission temporaire crée depuis la console.",
            LocalDate.now(),
            LocalDate.now().plusDays(3),
            Statut.A_PREPARER,
            Priorite.NORMALE,
            1250.00
            );
       
        int resultat=uneMissionDAO.ajouter(missionTest);
        if(resultat == 1){
            System.out.println ("Mission ajoutée");
        }else{
            System.out.println("echec");
        }
        
        missionTest.setTitre("Mission modifiée");
        boolean res=uneMissionDAO.modifier(missionTest);
        if (res){
            System.out.println("Mission modifiée");
        }else{
            System.out.println("modification echouée");
        }
             
        
        }catch (SQLException exception){
            System.out.println("Erreur : " + exception.getMessage());
        }
    }       
} 
    
  

