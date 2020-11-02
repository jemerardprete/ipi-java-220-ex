package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */

// 401 : Rendre la classe `Employe` abstraite

public abstract class Employe {
    // 101 : Ajout de champs avec getters/setters
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    // 102 : Définir constructeur par défaut
    public Employe(){

    }

    // 102 : Définir un constructeur avec l'ensemble des arguments précédemment créés
    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    // 103 : Déclarer méthode getNombreAnneeAnciennete calculant le nombre d'année d'ancienneté d'un employé
    public final Integer getNombreAnneeAnciennete(){
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }

    // 105 : Développer une méthode `getNbConges` retournant la constante de classe `NB_CONGES_BASE` de la classe `Entreprise`
    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    }

    // 109 : Coder la méthode `augmenterSalaire` prenant en paramètre un pourcentage d'augmentation de type `Double` et
    // augmentant l'attribut `salaire` du pourcentage passé en paramètre
    // augmentationPourcentage est non null et strictement positif. Elle augmenter le salaire du pourcentage renseigné
    // Ex : Salaire à 1000, pourcentage = 0.05 => salaire à 1050
    public void augmenterSalaire(Double augmentationPourcentage){
        this.salaire = this.salaire * (1 + augmentationPourcentage);
    }

    // 110 : Déclarer dans la classe `Employe` une méthode `getPrimeAnnuelle` retournant la prime annuelle de base définie dans la classe `Entreprise`
    // 402 : Rendre la méthode `getPrimeAnnuelle` d'`Employe` abstraite.
    public abstract Double getPrimeAnnuelle(); // si non abstraite, on affiche ceci : {return Entreprise.primeAnnuelleBase();}

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

    //  104 : Modifier le setter de `dateEmbauche` pour lever une `Exception` lorsque la date d'embauche est postérieure à la date courante
    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if(dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    // 106 :  Redéfinir la méthode `toString` héritée da la classe Objets (clic droit -> generate -> toString())
    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + "'" +
                ", prenom='" + prenom + "'" +
                ", matricule='" + matricule + "'" +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                '}';
    }

    // 107 : Redéfinir la méthode `equals` héritée da la classe Objets testant l'égalité sur l'ensemble des attributs de la classe `Employe`
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    // 108 : Redéfinir la méthode `hashCode` héritée da la classe Objets
    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }
}
