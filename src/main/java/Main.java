import com.ipiecoles.java.java220.Commercial;
import com.ipiecoles.java.java220.Employe;
import com.ipiecoles.java.java220.Entreprise;
import com.ipiecoles.java.java220.Technicien;
import org.joda.time.LocalDate;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(Entreprise.NB_CONGES_BASE);
        // Employe employe = new Employe();
        // Employe employe1 = new Employe("Doe", "John", "M12345", LocalDate.now(), 2500d);
        // Employe employe2 = new Employe("Doe", "John", "M12345", LocalDate.now(), 2500d);
        Commercial commercial = new Commercial("Doe", "John", "M12345", LocalDate.now(), 2500d, 1000000d);
        Technicien technicien = new Technicien("Doe", "John", "M12345", LocalDate.now().minusYears(10), 2500d, 4);

        // 104 : Exception
        //try {
        //    employe.setDateEmbauche(LocalDate.now().plusDays(5));
        //} catch (Exception e) {
        //    System.out.println(e.getMessage());
        //    System.out.println("Merci de saisir une nouvelle date d'embauche");
        //}
        //System.out.println(employe1.toString());
        //System.out.println(employe1.hashCode());
        //System.out.println(employe2.hashCode());
        //System.out.println(employe1.equals(employe2));

        //employe2.augmenterSalaire(0.50);
        //System.out.println(employe2);

        ArrayList<Employe> employes = new ArrayList<>();
        //employes.add(employe1);
        //employes.add(employe2);
        employes.add(commercial);
        employes.add(technicien);
        //employes.add(new Commercial());

        for(Employe e : employes){
            System.out.println("Prime : " + e.getPrimeAnnuelle());
        }
    }
}
