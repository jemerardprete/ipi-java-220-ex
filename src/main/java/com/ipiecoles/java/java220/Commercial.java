package com.ipiecoles.java.java220;

// 201 : Créer la classe `Commercial` et faire en sorte qu'elle hérite de la classe `Employe`
public class Commercial extends Employe {
    // 202 : Modifier la classe `Commercial` pour ajouter un attribut `caAnnuel` de type `Double` avec son getter et son setter
    private Double caAnnuel;

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    // 203 : Modifier la méthode `getPrimeAnnuelle` précédemment générée par l'IDE pour que la prime soit égale à 5% du
    // `caAnnuel`, avec un minimum de 500 € même en cas de chiffre d'affaire nul(l).

}
