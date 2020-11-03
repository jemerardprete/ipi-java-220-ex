package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

// 301 : Comme pour la classe `Commercial`, créer la classe `Technicien` et la faire hériter d'`Employe`
public class Technicien extends Employe {

    // 302 : Ajouter un attribut `grade` de type Integer
    private Integer grade;

    // 303 : Créer un constructeur pour la classe `Technicien` qui initialise tous les attributs hérités de la classe `Employe`
    // en faisant appel au constructeur d'`Employe` et qui initialise également l'attribut `grade`.

    public Technicien(){
        super();
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    // 302 : Getter et Setter grade

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    // 304 : Redéfinir le setter de l'attribut `salaire` pour qu'il renvoie la valeur de l'attribut `salaire`
    // auquel on ajoute la bonification du grade qui est égale à une augmentation de X0% par rapport au salaire de base :
    // Ex : Grade 3 : 30% d'augmentation : 1000.0 de salaire avec grade 1 : 1100.0

    @Override
    public void setSalaire(Double salaire) {
        if (grade == null){
            super.setSalaire(salaire);
        }
        super.setSalaire(salaire * (1 + grade / 10d));
    }

    // 305 : Redéfinir le getter de `nbConges` pour retourner le nombre de congés de base + autant de congés que d'année d'ancienneté.

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    // 306 : Redéfinir la méthode `getPrimeAnnuelle` pour qu'elle renvoie la prime annuelle de base à laquelle on ajoute
    // un pourcentage en fonction du grade (+10% pour grade 1, +30% pour grade 3...) ainsi que la prime d'ancienneté
    // multipliée par le nombre d'année d'ancienneté

    @Override
    public Double getPrimeAnnuelle() {
        // Prime annuelle de base
        Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
        // Ajout de la bonification du grade
        primeAnnuelleBase = primeAnnuelleBase + primeAnnuelleBase * (grade / 10d);
        return primeAnnuelleBase + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();

        // Version courte : return super.getPrimeAnnuelle() * (1 + (grade / 10d)) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "grade=" + grade +
                '}';
    }
}
