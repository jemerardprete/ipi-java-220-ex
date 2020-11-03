package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.Objects;

// 501a : Comme pour la classe `Commercial`, créer la classe `Manager` et la faire hériter d'`Employe`.


public class Manager extends Employe {

    // 502 : Modifier la classe `Manager` pour ajouter un attribut `equipe` permettant de stocker un ensemble non ordonné de techniciens avec son getter et son setter

    private HashSet<Technicien> equipe = new HashSet<>(); // Hashset contient éléments uniques

    public Manager(){
        super();
    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    // 503 : Ajouter une méthode `ajoutTechnicienEquipe` qui prend en paramètre un technicien et qui l'ajoute dans l'équipe

    public void ajoutTechnicienEquipe(Technicien technicien) {
        equipe.add(technicien);
    }

    // 508 : Surcharger `ajoutTechnicienEquipe` pour permettre l'ajout d'un technicien en passant directement les paramètres nom, prenom, matricule, date, salaire et grade

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
            Technicien technicien = new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade);
            this.ajoutTechnicienEquipe(technicien);
    }

    // 504 : Redéfinir le setter de l'attribut salaire pour qu'il renvoie la valeur du salaire multipliée par l'indice manager (`Entreprise.INDICE_MANAGER`, auquel on ajoute 10% par membre d'équipe

    @Override
    public void setSalaire(Double salaire) {
        Double salaireCalcule = salaire * Entreprise.INDICE_MANAGER;
        salaireCalcule = salaireCalcule + this.equipe.size() * salaire * 0.1;
        super.setSalaire(salaireCalcule);
    }

    // 501b : Constater le problème de compilation et utiliser l'IDE pour le résoudre.
    // 505 : Modifier le code de la méthode `getPrimeAnnuelle` pour qu'elle renvoie la prime de base, à laquelle on ajoute la prime du manager en fonction du nombre de membres de son équipe (en utilisant `Entreprise.PRIME_MANAGER_PAR_TECHNICIEN`)


    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + this.equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    // 506 : Ajouter une méthode interne `augmenterSalaireEquipe` qui augmente le salaire de tous les membres de l'équipe d'un manager par un pourcentage (`Double`) avec la méthode précédemment définie dans `Employe`

    private void augmenterSalaireEquipe(Double pourcentage){
        for(Technicien technicien : this.equipe){
            technicien.augmenterSalaire(pourcentage);
        }
    }

    // 507 : Redéfinir la méthode `augmenterSalaire` pour systématiquement augmenter le salaire de l'équipe d'un manager avant d'augmenter le salaire du manager...

    @Override
    public void augmenterSalaire(Double pourcentage) {
        for(Technicien technicien : equipe){
            super.augmenterSalaire(pourcentage);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(equipe, manager.equipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipe);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "equipe=" + equipe +
                '}';
    }
}