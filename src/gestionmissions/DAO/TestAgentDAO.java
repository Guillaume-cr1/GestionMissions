/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmissions.DAO;

import gestionmissions.Metier.Agent;
import java.sql.SQLException;
import java.util.List;

public class TestAgentDAO {

    public static void main(String[] args) {

        AgentDAO agentDAO = new AgentDAO();

        try {

            // Création d'un agent de test
            Agent agent = new Agent();

            agent.setPseudo("test_" + System.currentTimeMillis());
            agent.setNom("Dupont");
            agent.setSpecialite("Developpement");
            agent.setNiveau(2);
            agent.setActif(true);

            // Ajout dans la base de données
            agentDAO.ajouterAgent(agent);

            System.out.println("Agent ajouté avec succès !");

            // Récupération des agents
            List<Agent> agents = agentDAO.listerAgents();

            System.out.println("Liste des agents :");

            for (Agent a : agents) {
                System.out.println(
                    a.getIdAgent() + " - "
                    + a.getPseudo() + " - "
                    + a.getNom() + " - "
                    + a.getSpecialite() + " - "
                    + a.getNiveau() + " - "
                    + a.isActif()
                );
            }

        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

