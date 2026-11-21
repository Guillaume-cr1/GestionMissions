/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmissions.DAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Utilisateur
 */
public class TestParticipationDAO {
    
    public static void main(String[] args) throws SQLException {

        ParticipationDAO uneParticipationDAO = new ParticipationDAO();

        List<Object[]> lesParticipations = uneParticipationDAO.lister();

        for (Object[] participation : lesParticipations) {

            System.out.println("Agent : " + participation[1]
                    + " " + participation[2]);

            System.out.println("Mission : " + participation[4]);

            System.out.println("Rôle : " + participation[5]);

            System.out.println("Date d'affectation : " + participation[6]);

            System.out.println("--------------------------");
        }
    }
}
