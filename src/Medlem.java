import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Medlem {
    public static ArrayList<Medlem> medlemmer;

    static Scanner tast = new Scanner(System.in);
    private static int nextMedlemID = 100;
    String navn;
    String køn;
    int medlemID;
    int alder;
    String aktivitetsform;
    int restance;
    int tlf;

    Medlem(String navn, int alder, String af, int tlf, String køn) {
        this.navn = navn;
        this.medlemID = nextMedlemID++;
        this.alder = alder;
        aktivitetsform = af;
        this.restance = 1600;
        this.tlf = tlf;
        this.køn = køn;
    }

    public Medlem() {
        if (medlemmer == null) {
            medlemmer = new ArrayList<>();
        }
    }

    public void opretMedlem() {
        System.out.println("\n Medlemmer ⇩");
        System.out.println("Indtast navn");
        String navn = tast.nextLine();
        System.out.println("Indtast køn");
        String køn = tast.nextLine();
        if (køn.equalsIgnoreCase("Mand") || køn.equalsIgnoreCase("kvinde")) {
            System.out.println("Indtast alder");
            int alder = tast.nextInt();
            System.out.println("Indtast ønsket aktivitet");
            tast.nextLine();
            String af = tast.nextLine();
            System.out.println("Indtast Telefon nummer");
            int tlf = tast.nextInt();
            Medlem nyMedlem = new Medlem(navn, alder, af, tlf, køn);
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
        return "Medlem: "+ navn+", "+køn+", "+alder +"\n\nMedlems ID: "+ medlemID +"\n\nAktivitetsform: "+aktivitetsform+"\n\nTelefon: +45" +tlf+ "\n\nRestance: " +restance+"\n_____________________\n";
    }
}

class Svømmer extends Medlem {
    int nextMedlemID = 200;
    double tid;
    LocalDate dato;
    String discipliner;

    Svømmer(String navn, int alder, String af, int tlf, String køn, double tid, LocalDate dato, String dp) {
        super(navn, alder, af, tlf, køn);
        this.tid = tid;
        this.dato = dato;
        discipliner = dp;
        this.medlemID = nextMedlemID++;
    }
}
