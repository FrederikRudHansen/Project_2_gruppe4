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
    String filsti = "Medlemmer.txt";


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



    public void visRestance() {
        for (Medlem medlem : medlemmer) {
            System.out.println("Navn: " + medlem.navn);
            System.out.println("Restance " + medlem.restance);
            System.out.println("Id " + medlem.medlemID + "\n\n");
        }
    }

    public void fastmedlem() {
        if (fastmedlemoprettet == false) {

        }
    }

    public void opretMedlem() {
        System.out.println("\n Medlemmer ⇩\n");
        System.out.println("Indtast navn");

        navn = tast.nextLine();

        System.out.println("Indtast køn");
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
            System.out.println("Indtast ønsket aktivitet");

            String af = tast.nextLine();
            System.out.println("Indtast Telefon nummer");
            int tlf = Integer.parseInt(tast.nextLine());

            Medlem nyMedlem = new Medlem(navn, alder, af, tlf, køn, restance);
            medlemmer.add(nyMedlem);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filsti))) { //GEMMER MEDLEMMER I "Medlemmer.txt" FIL
                writer.write(nyMedlem.toString());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        return "Medlem: " + navn + ", " + køn + ", " + alder + "\n\nMedlems ID: " + IdBogstav+ medlemID + "\n\nAktivitetsform: " + aktivitetsform + "\n\nTelefon: +45" + tlf + "\n\nRestance: " + restance + "\n_____________________\n";
    }
}
  
