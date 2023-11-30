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


    Medlem(String navn, int alder, String af, int tlf, String køn, int restance) {
        this.navn = navn;
        this.medlemID = nextMedlemID++;
        this.alder = alder;
        aktivitetsform = af;
        this.restance=restance;
        this.tlf = tlf;
        this.køn = køn;

    }

    public Medlem() {
        if (medlemmer == null) {
            medlemmer = new ArrayList<>();
        }
    }

    public void visRestance(){
        for (Medlem medlem : medlemmer){
            System.out.println("Navn: "+ medlem.navn);
            System.out.println("Restance "+ medlem.restance);
            System.out.println("Id "+ medlem.medlemID+"\n\n");
        }
    }

    public void opretMedlem() {
        System.out.println("\n Medlemmer ⇩");
        System.out.println("Indtast navn");

        navn = tast.nextLine();

        System.out.println("Indtast køn");
        køn = tast.nextLine();
        if (køn.equalsIgnoreCase("Mand") || køn.equalsIgnoreCase("kvinde")) {

            System.out.println("Indtast alder");
            int alder = Integer.parseInt(tast.nextLine());
            int restance;
            if (alder < 17){
                restance=+1000;
            }else{
                restance=+1600;
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

    Svømmer(String navn, int alder, String af, int tlf, String køn, double tid, LocalDate dato, String dp, int restance) {
        super(navn,alder,af,tlf,køn,restance);
        this.tid = tid;
        this.dato = dato;
        discipliner = dp;
        this.medlemID = nextMedlemID++;
    }
}
