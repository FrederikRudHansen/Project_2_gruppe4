import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Medlem {
    public static ArrayList<Medlem> medlemmer = new ArrayList<>();
    public static ArrayList<Svømmer> svømmere = new ArrayList<>();

    static Scanner tast = new Scanner(System.in);
    private static int nextMedlemID = 100;
    String navn;
    String navnE;
    String køn;
    String kønE;
    int medlemID;
    int alder;
    int alderE;
    String aktivitetsform;
    int restance;
    int tlf;
    int typeMedlem;

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
        System.out.println("\nTast 1 for oprettelse af Standard Medlemsskab");
        System.out.println("\nTast 2 for oprettelse af Elite Svømmer");
        typeMedlem = tast.nextInt();

        switch (typeMedlem) {
            case 1:
                System.out.println("\n Medlemmer ⇩\n");
                System.out.println("Indtast navn");
                tast.nextLine();
                navn = tast.nextLine();
                System.out.println("Indtast køn");
                køn = tast.nextLine();
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
                break;
            case 2:
                System.out.println("\nElite Svømmere ⇩\n");
                System.out.println("Indtast navn");
                tast.nextLine();
                String navnE = tast.nextLine();
                System.out.println("Indtast køn");
                String kønE = tast.nextLine();
                if (kønE.equalsIgnoreCase("Mand") || kønE.equalsIgnoreCase("kvinde")) {
                    System.out.println("Indtast alder");
                    int alderE = tast.nextInt();
                    System.out.println("Indtast Telefon nummer");
                    int tlf = tast.nextInt();
                    System.out.println("Indtast disciplin");
                    tast.nextLine();
                    String dp = tast.nextLine();
                    System.out.println("Indtast bedste tid [XX.XX]");
                    double tid = tast.nextDouble();
                    System.out.println("Indtast dato for tiden [dd-mm-yyyy]");
                    tast.nextLine();
                    String dato = tast.nextLine();
                    Svømmer nySvømmer = new Svømmer(navnE, alderE, dp, tlf, kønE, tid, dato, dp);
                    svømmere.add(nySvømmer);
                    Menu.menu();
                } else {
                    System.out.println("Not a køn stupid");
                }
                break;
            default:
                System.out.println("Opfør dig ordenligt adam, prøv igen");
                break;
        }
    }

    @Override
    public String toString() {
        String typeMedlemString;
        if (typeMedlem == 0) {
            typeMedlemString = "Standard Medlemsskab";
            return "Medlem: " + navn + ", " + køn + ", " + alder + "\n\nMedlemskabs type: " + typeMedlemString + "\n\nMedlems ID: " + medlemID + "\n\nAktivitetsform: " + aktivitetsform + "\n\nTelefon: +45" + tlf + "\n\nRestance: " + restance + "\n_____________________\n";
        } else if (typeMedlem == 1) {
            typeMedlemString = "Elite Svømmer";
            if (this instanceof Svømmer) {
                Svømmer eliteSvømmer = (Svømmer) this;
                return eliteSvømmer.toString();
            } else {
                typeMedlemString = "Ukendt medlemsstype";
            }
        }
        return "";
    }

class Svømmer extends Medlem {
    int nextMedlemID = 200;
    double tid;
    String dato;
    String discipliner;

    Svømmer(String navn, int alder, String af, int tlf, String køn, double tid, String dato, String dp) {
        super(navn, alder, af, tlf, køn);
        this.tid = tid;
        this.dato = dato;
        discipliner = dp;
        this.medlemID = nextMedlemID++;
    }

    @Override
    public String toString() { // PROBLEMET ER AT DEN PRINTER TID + DATO UNDER DEN RIGTIGE TOSTRING
        return super.toString()+"\n\nBedste tid: "+tid+ "Dato for Bedste tid: "+dato+ "\n";

    }
}
}
