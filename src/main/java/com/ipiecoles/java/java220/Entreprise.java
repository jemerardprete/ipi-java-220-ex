package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;

public class Entreprise {
    // 001 : déclarer constantes de classe
    public static final Double SALAIRE_BASE = 1480.27;
    public static final Integer NB_CONGES_BASE = 25;
    public static final Double INDICE_MANAGER = 1.3;
    public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250d; //250.0
    public static final Double PRIME_ANCIENNETE = 100d;

    // 002 : calcul prime de base pour les employés : Prime = 50% de l'année en cours
    public static Double primeAnnuelleBase() {
        return (double)LocalDate.now().getYear()/2d; // /2d = /2.0 ou *0.5 : année courante
    }

}
