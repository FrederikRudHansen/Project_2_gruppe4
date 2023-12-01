import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Medlem {
    public static ArrayList<Medlem> medlemmer = new ArrayList<>();
    public static boolean fastmedlemoprettet = false;
    static Scanner tast = new Scanner(System.in);
    private static int nextMedlemID = 100;
    String navn;
    String køn;
    int medlemID;
    int alder;
    String aktivitetsform;
    int restance;
    int tlf;


    Medlem(String navn, int alder, String af, int tlf, String køn, int restance) {
        this.navn = navn;
        this.medlemID = nextMedlemID++;
        this.alder = alder;
        aktivitetsform = af;
        this.restance = restance;
        this.tlf = tlf;
        this.køn = køn;
    }

    public Medlem() {
        if (medlemmer == null) {
            medlemmer = new ArrayList<>();
        }
    }

    public void visRestance() {
        for (Medlem medlem : medlemmer) {
            System.out.println("Navn: " + medlem.navn);
            System.out.println("Restance " + medlem.restance);
            System.out.println("Id " + medlem.medlemID + "\n\n");
        }
    }

    public void fastmedlem() {
        if (fastmedlemoprettet == false) {
            Medlem nyMedlem1 = new Medlem("Goku", 30, "Elite Svømmer", 12345678, "Mand",1600);
            Medlem nyMedlem2 = new Medlem("Vegeta", 36, "Elite Svømmer", 10010001, "Mand",1600);
            Medlem nyMedlem3 = new Medlem("Piccolo", 55, "Elite Svømmer", 66666666, "Mand",1600);
            Medlem nyMedlem4 = new Medlem("Krillin", 29, "Elite Svømmer", 69696969, "Mand",1600);
            Medlem nyMedlem5 = new Medlem("Tenshinhan", 31, "Elite Svømmer", 21212121, "Mand",1600);
            medlemmer.add(nyMedlem1);
            medlemmer.add(nyMedlem2);
            medlemmer.add(nyMedlem3);
            medlemmer.add(nyMedlem4);
            medlemmer.add(nyMedlem5);
            fastmedlemoprettet = true;
        }
    }

    public void opretMedlem() {
        System.out.println("\n Medlemmer ⇩\n");
        System.out.println("Indtast navn");

        navn = tast.nextLine();

        System.out.println("Indtast køn");
        køn = tast.nextLine();
        if (køn.equalsIgnoreCase("Mand") || køn.equalsIgnoreCase("kvinde")) {

            System.out.println("Indtast alder");
            int alder = Integer.parseInt(tast.nextLine());
            int restance;
            if (alder < 18) {
                restance = +1000;
            } else {
                restance = +1600;
            }
            System.out.println("Indtast ønsket aktivitet");

            String af = tast.nextLine();
            System.out.println("Indtast Telefon nummer");
            int tlf = Integer.parseInt(tast.nextLine());
            Medlem nyMedlem = new Medlem(navn, alder, af, tlf, køn, restance);
            medlemmer.add(nyMedlem);

            Menu.menu();
        } else {
            System.out.println("not a køn");
        }
    }

    public void sletMedlem(int medlemsID) {  // sletmedlemID
        for (Medlem medlem : medlemmer) {
            if (medlem.medlemID == medlemsID) {
                medlemmer.remove(medlem);
                System.out.println("Medlem med ID " + medlemsID + " er blevet slettet.");
                return; // Når medlemmet er fundet og slettet, afsluttes metoden.
            }
        }
        System.out.println("Medlem med ID " + medlemsID + " blev ikke fundet.");
    }

    public void sletDeltagelse(int konkurrenceID, int medlemsID) {
        for (Medlem medlem : medlemmer) {
            if (medlem.medlemID == medlemsID) {
                medlem.sletDeltagelse(konkurrenceID);
                return; // Når deltagelsen er fjernet, afsluttes metoden.
            }
        }
        System.out.println("Medlem med ID " + medlemsID + " blev ikke fundet.");
    }

    public void sletDeltagelse(int konkurrenceID) {
        // Implementer logikken til at fjerne deltagelsen i konkurrencen baseret på konkurrenceID
    }

    @Override
    public String toString() {
        return "Medlem: " + navn + ", " + køn + ", " + alder + "\n\nMedlems ID: " + medlemID + "\n\nAktivitetsform: " + aktivitetsform + "\n\nTelefon: +45" + tlf + "\n\nRestance: " + restance + "\n_____________________\n";
    }
}
  
