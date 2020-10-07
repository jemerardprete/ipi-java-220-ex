package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
    // 101 : Ajout de champs avec getters/setters
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    // 102
    // Définir constructeur par défaut
    // Définir un constructeur avec l'ensemble des arguments précédemment créés
    // Décommenter la ligne 122 de EntrepriseTest

    // 103
    // Déclarer méthode getNombreAnneeAnciennete calculant le nombre d'année d'ancienneté d'un employé

    // 105
    // Développer méthode getNbConges retournant la constante de classe NB_CONGES_BASE de la classe Entreprise
}
