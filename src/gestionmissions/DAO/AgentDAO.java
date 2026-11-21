/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmissions.DAO;
import gestionmissions.Metier.Agent;
import gestionmissions.Connexion.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Utilisateur
 */
public class AgentDAO {

    public void ajouterAgent(Agent agent) throws SQLException {

        String sql = "INSERT INTO agent "
                + "(pseudo, nom, specialite, niveau, actif) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connexion = ConnexionBDD.obtenirConnexion();
             PreparedStatement requete =
                     connexion.prepareStatement(sql)) {

            requete.setString(1, agent.getPseudo());
            requete.setString(2, agent.getNom());
            requete.setString(3, agent.getSpecialite());
            requete.setInt(4, agent.getNiveau());
            requete.setBoolean(5, agent.isActif());

            requete.executeUpdate();
        }
    }

    // Récupérer tous les agents de la base de données
    public List<Agent> listerAgents() throws SQLException {

        List<Agent> agents = new ArrayList<>();

        String sql = "SELECT id_agent, pseudo, nom, "
                + "specialite, niveau, actif FROM agent";

        try (Connection connexion = ConnexionBDD.obtenirConnexion();
             PreparedStatement requete =
                     connexion.prepareStatement(sql);
             ResultSet resultat = requete.executeQuery()) {

            while (resultat.next()) {

                Agent agent = new Agent(
                        resultat.getInt("id_agent"),
                        resultat.getString("pseudo"),
                        resultat.getString("nom"),
                        resultat.getString("specialite"),
                        resultat.getInt("niveau"),
                        resultat.getBoolean("actif")
                );

                agents.add(agent);
            }
        }

        return agents;
    }
    
    // Modifier les informations d'un agent
    public void modifierAgent(Agent agent) throws SQLException {

        String sql = "UPDATE agent SET pseudo = ?, nom = ?, "
            + "specialite = ?, niveau = ?, actif = ? "
            + "WHERE id_agent = ?";

        try (Connection connexion = ConnexionBDD.obtenirConnexion();
         PreparedStatement requete = connexion.prepareStatement(sql)) {

            requete.setString(1, agent.getPseudo());
            requete.setString(2, agent.getNom());
            requete.setString(3, agent.getSpecialite());
            requete.setInt(4, agent.getNiveau());
            requete.setBoolean(5, agent.isActif());
            requete.setInt(6, agent.getIdAgent());

            requete.executeUpdate();
        }
    }

}

