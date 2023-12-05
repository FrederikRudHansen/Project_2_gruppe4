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

        System.out.println("\nIndtast fødselsdag (dd-mm-yyyy)");

        boolean gyldig = false;

        while (!gyldig) {
            try {
                String dato = tast.nextLine();
                LocalDate fødselsdag = LocalDate.parse(dato, datoFormatter);

                System.out.println("\nFødseldag: " + fødselsdag.format(datoFormatter));

                Thread.sleep(1000);
                System.out.print("\nBeregner alder");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);         //DRAMATISK EFFEKT. SLET HVIS IRRITERENDE
                System.out.print(".");
                Thread.sleep(1000);
                System.out.println(".");
                Thread.sleep(1000);

                alder = beregnAlder2(fødselsdag, LocalDate.now());
                System.out.println("\nAlder: " + alder + " år");
                Thread.sleep(1000);

                gyldig = true;

            } catch (Exception e) {
                System.out.println("\nUgyldig format. brug dd-mm-yyyy");
            }
        }

        return alder;
    }
}
