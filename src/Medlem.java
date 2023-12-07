import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Medlem {

    public static ArrayList<Medlem> medlemmer = new ArrayList<>();
    public static boolean fastmedlemoprettet = false;
    static Scanner tast = new Scanner(System.in);
    public static int nextMedlemID = 100;
    String navn;
    String IdBogstav="M-";
    String køn;
    int medlemID;
    int alder;
    String aktivitetsform;
    int restance;
    int tlf;

    Medlem(String navn, int alder, String af, int tlf, String køn, int restance) {
        this.navn = navn;
        this.medlemID =nextMedlemID++;
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

    public void visRestance() { // restance metode
        for (Medlem medlem : medlemmer) {
            System.out.println("Navn: " + medlem.navn);
            System.out.println("Restance " + medlem.restance);
            System.out.println("Id " + medlem.medlemID + "\n\n");
        }
    }

    public void opretMedlem() { //start på opret medlem
        boolean aktivPassiv =true;
        System.out.println("\n Medlemmer ⇩\n");
        System.out.println("Indtast navn");

        navn = tast.nextLine();

        System.out.println("\nIndtast køn");
        køn = tast.nextLine();
        if (køn.equalsIgnoreCase("Mand") || køn.equalsIgnoreCase("kvinde")) {

            int alder = Alderberegning.beregnAlder();
            int restance;
            if (alder < 18) {
                restance = +1000;
            }else if (alder > 17 && alder <60) {
                restance = +1600;
            } else {
                restance = 1200;
            }
            System.out.println("\nIndtast ønsket passiv eller aktiv");
            String af = tast.nextLine();
                while(aktivPassiv) {

                        if (af.equalsIgnoreCase("passiv")) {
                            restance = 500;
                            aktivPassiv = false;
                        }else if (af.equalsIgnoreCase("aktiv")) {
                            aktivPassiv = false;
                        } else {
                            System.out.println("Ikke gyldigt, prøv igen");
                            af = tast.nextLine();
                        }
                    }
            System.out.println("\nIndtast Telefon nummer");
            int tlf = Integer.parseInt(tast.nextLine());
            Medlem nyMedlem = new Medlem(navn, alder, af, tlf, køn, restance);
            medlemmer.add(nyMedlem);
            Menu.menu();
        } else {
            System.out.println("not a køn");
        }
    } // slut på opret medlem

    public void setRestance(int nyRestance) {
        this.restance = nyRestance;
    }

    public void sletMedlem(int medlemsID) {
        for (Medlem medlem : medlemmer) {
            if (medlem.medlemID == medlemsID) {
                medlemmer.remove(medlem);
                System.out.println("Medlem med ID " + medlemsID + " er blevet slettet.");
                return;
            }
        }
        System.out.println("Medlem med ID " + medlemsID + " blev ikke fundet.");
    }

    @Override
    public String toString() {
        return "Medlem: " + navn + ", " + køn + ", " + alder + "\n\nMedlems ID: " + IdBogstav+ medlemID + "\n\nAktivitetsform: " + aktivitetsform + "\n\nTelefon: +45" + tlf + "\n\nRestance: " + restance + "\n_____________________\n";
    }

    public String filGem(){
        return navn+","+køn+","+alder+","+IdBogstav+","+medlemID+","+aktivitetsform+","+tlf+","+restance;
    }
}