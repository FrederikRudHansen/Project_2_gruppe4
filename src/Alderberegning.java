import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Alderberegning {
    public static int beregnAlder2(LocalDate fødselsdag, LocalDate referenceDag) {
        return Period.between(fødselsdag, referenceDag).getYears();
    }

    public static int beregnAlder() { //en metode så at personen kan give sin nøjagtig fødselsdag, så at person også bliver ældre.
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

                // det er en lille "loading" for at give programmet noget visuelt
                String[] frames = {"Beregner alder: ⠋", "Beregner alder: ⠙", "Beregner alder: ⠹", "Beregner alder: ⠸", "Beregner alder: ⠼", "Beregner alder: ⠴", "Beregner alder: ⠦", "Beregner alder: ⠧", "Beregner alder: ⠇", "Beregner alder: ⠏"};
                for (int i = 0; i < 50; i++) {
                    System.out.print("\r" + frames[i % frames.length]);
                    Thread.sleep(50);
                }
                alder = beregnAlder2(fødselsdag, LocalDate.now());
                System.out.println("\nAlder: " + alder + " år");
                Thread.sleep(1000);

                gyldig = true;
            } catch (Exception e) { // hvis nu at man skriver en dato der ikke er gyldig
                System.out.println("\nUgyldig format. brug dd-mm-yyyy");
            }
        }
        return alder;
    }
}