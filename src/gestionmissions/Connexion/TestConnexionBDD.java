/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmissions.Connexion;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Utilisateur
 */
public class TestConnexionBDD {

    public static void main(String[] args) {

        try {
            Connection connexion = ConnexionBDD.obtenirConnexion();

            System.out.println("Connexion à MySQL réussie !");

            connexion.close();

        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}