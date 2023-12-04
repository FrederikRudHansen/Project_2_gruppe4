import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Alderberegning {
    public static int beregnAlder2(LocalDate fødselsdag, LocalDate referenceDag) {
        return Period.between(fødselsdag, referenceDag).getYears();
    }

    public static int beregnAlder() {
        Scanner tast = new Scanner(System.in);
        DateTimeFormatter datoFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int alder = 0; // Initialiser alder uden for try-blokken

        System.out.println("indtast fødselsdag (dd-mm-yyyy)");

        boolean gyldig = false;

        while (!gyldig) {
            try {
                String dato = tast.nextLine();
                LocalDate fødselsdag = LocalDate.parse(dato, datoFormatter);

                System.out.println("Fødseldag: " + fødselsdag.format(datoFormatter));

                alder = beregnAlder2(fødselsdag, LocalDate.now());
                System.out.println("Alder: " + alder + " år");

                gyldig = true;

            } catch (Exception e) {
                System.out.println("ugyldig format. brug dd-mm-yyyy");
            }
        }

        return alder;
    }
}
