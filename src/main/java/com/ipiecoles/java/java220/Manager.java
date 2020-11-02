package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;

import java.util.HashSet;

// 501a : Comme pour la classe `Commercial`, créer la classe `Manager` et la faire hériter d'`Employe`.


public class Manager extends Employe {

    // 502 : Modifier la classe `Manager` pour ajouter un attribut `equipe` permettant de stocker un ensemble non ordonné de techniciens avec son getter et son setter

    private HashSet<Technicien> equipe = new HashSet<>(); // Hashset contient éléments uniques

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

    // 501b : Constater le problème de compilation et utiliser l'IDE pour le résoudre.

    @Override
    public Double getPrimeAnnuelle() {
        return null;
    }
}

// 504 : Redéfinir le setter de l'attribut salaire pour qu'il renvoie la valeur du salaire multipliée par l'indice manager (`Entreprise.INDICE_MANAGER`, auquel on ajoute 10% (sur le salaire passé en paramètre) par membre d'équipe

// 505 : Modifier le code de la méthode `getPrimeAnnuelle` pour qu'elle renvoie la prime de base, à laquelle on ajoute la prime du manager en fonction du nombre de membres de son équipe (en utilisant `Entreprise.PRIME_MANAGER_PAR_TECHNICIEN`)

// 506 : Ajoutée une méthode interne `augmenterSalaireEquipe` qui augmente le salaire de tous les membres de l'équipe d'un manager par un pourcentage (`Double`) avec la méthode précédemment définie dans `Employe`

// 507 : Redéfinir la méthode `augmenterSalaire` pour systématiquement augmenter le salaire de l'équipe d'un manager avant d'augmenter le salaire du manager...

// 508 : Surcharger `ajoutTechnicienEquipe` pour permettre l'ajout d'un technicien en passant directement les paramètres nom, prenom, matricule, date, salaire et grade