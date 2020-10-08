package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

// 201 : Créer la classe `Commercial` et faire en sorte qu'elle hérite de la classe `Employe`
public class Commercial extends Employe {
    // 202 : Ajouter un attribut `caAnnuel` de type `Double`
    private Double caAnnuel;

    // 206.1 : Ajouter attribut performance de type Integer
    private Integer performance;

    // 204 : Créer un constructeur pour la classe `Commercial` qui initialise tous les attributs hérités de la classe
    // `Employe` en faisant appel au constructeur d'`Employe` et qui initialise également l'attribut `caAnnuel`

    public Commercial(){
        super();
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = performance;
    }

    // 202 : Getter et Setter de caAnnuel

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    // 206.1 : Getter et Setter de performance

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    // 203 : Modifier la méthode `getPrimeAnnuelle` précédemment générée par l'IDE pour que la prime soit égale à 5% du
    // `caAnnuel`, avec un minimum de 500 € même en cas de chiffre d'affaire nul(l).

    @Override
    public Double getPrimeAnnuelle() {
        if (this.caAnnuel != null) {
            return Math.max(Math.ceil(this.caAnnuel * 0.05), 500d);
        }
        return 500d;
    }

    // 206.2 : Ajouter une méthode `performanceEgale` prenant un `Integer` en paramètre qui renvoie `true` si la
    // performance du commercial est égale à celle passée en paramètre, `false` sinon
    public Boolean performanceEgale(Integer perf) {
       return Objects.equals(perf, this.performance);
    }

    // 205 : Redéfinir la méthode `equals` pour permettre de tester l'égalité entre deux instances de la classe `Commercial`

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel) &&
               Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel, performance);
    }

    @Override
    public String toString() {
        return "Commercial{" +
                "caAnnuel=" + caAnnuel +
                ", performance=" + performance +
                "}" + super.toString();
    }
}
