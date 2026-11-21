
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmissions.Metier;
/**
 *
 * @author Utilisateur
 */

public class Agent {

    private int idAgent;
    private String pseudo;
    private String nom;
    private String specialite;
    private int niveau;
    private boolean actif;

    public Agent() {
    }

    public Agent(int idAgent, String pseudo, String nom, String specialite, int niveau, boolean actif) {
        this.idAgent = idAgent;
        this.pseudo = pseudo;
        this.nom = nom;
        this.specialite = specialite;
        this.niveau = niveau;
        this.actif = actif;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}
