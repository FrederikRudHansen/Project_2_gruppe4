import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Medlem {
    public static ArrayList<Medlem> medlemmer;
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

    public void fastmedlem() {
        if (fastmedlemoprettet == false) {
            Medlem nyMedlem1 = new Medlem("Goku", 30, "konkurrencesvømmer", 12345678, "Mand");
            Medlem nyMedlem2 = new Medlem("Vegeta", 36, "konkurrencesvømmer", 10010001, "Mand");
            Medlem nyMedlem3 = new Medlem("Piccolo", 55, "konkurrencesvømmer", 66666666, "Mand");
            Medlem nyMedlem4 = new Medlem("Krillin", 29, "konkurrencesvømmer", 69696969, "Mand");
            Medlem nyMedlem5 = new Medlem("Tenshinhan", 31, "konkurrencesvømmer", 21212121, "Mand");
            medlemmer.add(nyMedlem1);
            medlemmer.add(nyMedlem2);
            medlemmer.add(nyMedlem3);
            medlemmer.add(nyMedlem4);
            medlemmer.add(nyMedlem5);
            fastmedlemoprettet = true;
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
    @Override
    public String toString() {
        return "Medlem: "+ navn+", "+køn+", "+alder +"\n\nMedlems ID: "+ medlemID +"\n\nAktivitetsform: "+aktivitetsform+"\n\nTelefon: +45" +tlf+ "\n\nRestance: " +restance+"\n_____________________\n";
    }
}