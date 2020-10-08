import com.ipiecoles.java.java220.Employe;
import com.ipiecoles.java.java220.Entreprise;
import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(Entreprise.NB_CONGES_BASE);
        Employe employe = new Employe();
        Employe employe1 = new Employe("Doe", "John", "M12345", LocalDate.now(), 2500d);
        Employe employe2 = new Employe("Doe", "John", "M12345", LocalDate.now(), 2500d);
        // 104 : Exception
        try {
            employe.setDateEmbauche(LocalDate.now().plusDays(5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Merci de saisir une nouvelle date d'embauche");
        }
        System.out.println(employe1.toString());
        System.out.println(employe1.hashCode());
        System.out.println(employe2.hashCode());
        System.out.println(employe1.equals(employe2));
    }
}
