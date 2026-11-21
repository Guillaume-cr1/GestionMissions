/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmissions.Metier;
import java.time.LocalDate;

/**
 *
 * @author Utilisateur
 */
public class Participation {
    
    private int idAgent;
    private int idMission;
    private String role;
    private LocalDate dateAffectation;

    public Participation(int idAgent, int idMission, String role, LocalDate dateAffectation) {
        this.idAgent = idAgent;
        this.idMission = idMission;
        this.role = role;
        this.dateAffectation = dateAffectation;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(LocalDate dateAffectation) {
        this.dateAffectation = dateAffectation;
    }
}
