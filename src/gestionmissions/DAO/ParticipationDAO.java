
package gestionmissions.DAO;
import gestionmissions.Connexion.ConnexionBDD;
import gestionmissions.Metier.Participation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Utilisateur
 */
public class ParticipationDAO {
    public int ajouter(Participation participation) throws SQLException {

        String sql = "INSERT INTO participation "
                + "(id_agent, id_mission, role, date_affectation) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection connexion = ConnexionBDD.obtenirConnexion();
             PreparedStatement requete = connexion.prepareStatement(sql)) {

            requete.setInt(1, participation.getIdAgent());
            requete.setInt(2, participation.getIdMission());
            requete.setString(3, participation.getRole());
            requete.setDate(4, Date.valueOf(participation.getDateAffectation()));

            return requete.executeUpdate();
        }
    }
    public List<Object[]> lister() throws SQLException {

    List<Object[]> participations = new ArrayList<>();

    String sql = "SELECT agent.id_agent, agent.pseudo, agent.nom, "
        + "mission.id, mission.titre, "
        + "participation.role, participation.date_affectation "
        + "FROM participation "
        + "INNER JOIN agent ON participation.id_agent = agent.id_agent "
        + "INNER JOIN mission ON participation.id_mission = mission.id";

    try (Connection connexion = ConnexionBDD.obtenirConnexion();
         PreparedStatement requete = connexion.prepareStatement(sql);
         ResultSet resultat = requete.executeQuery()) {

        while (resultat.next()) {

            Object[] ligne = {
                resultat.getInt("id_agent"),
                resultat.getString("pseudo"),
                resultat.getString("nom"),
                resultat.getInt("id"),
                resultat.getString("titre"),
                resultat.getString("role"),
                resultat.getDate("date_affectation")
            };

            participations.add(ligne);
        }
    }

    return participations;
}
   public int modifier(Participation participation,
        int ancienIdAgent, int ancienneIdMission) throws SQLException {

    String sql = "UPDATE participation SET "
            + "id_agent = ?, id_mission = ?, role = ?, date_affectation = ? "
            + "WHERE id_agent = ? AND id_mission = ?";

    try (Connection connexion = ConnexionBDD.obtenirConnexion();
         PreparedStatement requete = connexion.prepareStatement(sql)) {

        requete.setInt(1, participation.getIdAgent());
        requete.setInt(2, participation.getIdMission());
        requete.setString(3, participation.getRole());
        requete.setDate(4, Date.valueOf(participation.getDateAffectation()));

        requete.setInt(5, ancienIdAgent);
        requete.setInt(6, ancienneIdMission);

        return requete.executeUpdate();
    }
} 
}
