import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Svømmer extends Medlem implements Comparable<Svømmer> {

    public static ArrayList<Svømmer> svømmer = new ArrayList<>();
    public static ArrayList<Svømmer> top5svømmer = new ArrayList<>();
    public double tid;
    public LocalDate dato;
    String stævne;
    String idBogstav="S-";

        Svømmer(String navn, int alder, String af, int tlf, String køn, double tid, LocalDate dato, String st,int restance) {
            super(navn, alder, af, tlf, køn,restance); // nedarvning fra Medlem
            this.tid = tid;
            this.dato = dato;
            stævne = st;
        }

        Svømmer (){
            if (svømmer == null) {
                svømmer = new ArrayList<>();
            }
    }



    public void top5svømmere() { //metode til at vise top 5 svømmer
        Collections.sort(svømmer);
        top5svømmer.clear();
        top5svømmer.addAll(svømmer.subList(0, Math.min(5, svømmer.size())));
    }

    @Override
    public String toString() { // sådan en svømmer udprintes til terminalen
        return "Medlem: "+ navn+", "+køn+", "+alder +"\n\nMedlems ID: "+idBogstav+ medlemID +"\n\nSluttidspunkt: " + tid +"\n\nDisciplin: "+aktivitetsform+ "\n\nStævne: " + stævne + "\n\nDato: " + dato +
                "\n\nTelefon: +45" +tlf+"\n\nRestance: " +restance+"\n_____________________\n";
    }

    public void opretEliteSvømmer(){ //start på opret svømmer metoden
        System.out.println("\n Elite Svømmere ⇩\n");
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
            System.out.println("\nIndtast disciplin");
            String dp = tast.nextLine();
            System.out.println("\nIndtast stævne");
            stævne = tast.nextLine();
            System.out.println("\nIndtast bedste tid");
            double tid = tast.nextDouble();
            System.out.println("\nIndtast dato for bedste tid [dd-MM-yyyy]");

            tast.nextLine();
            String datoString = tast.nextLine();
            DateTimeFormatter datoFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dato = LocalDate.parse(datoString,datoFormatter);

            System.out.println("\nIndtast Telefon nummer");
            int tlf = Integer.parseInt(tast.nextLine());
            Svømmer nySvømmer = new Svømmer(navn,alder,dp,tlf,køn,tid,dato,stævne,restance);
            svømmer.add(nySvømmer);
            Menu.menu();
        } else {
            System.out.println("not a køn stupid");
        }
    } //slutning på opret svømmer metoden

    public void sletSvømmer(int medlemsID) {
        Iterator<Svømmer> iterator = svømmer.iterator();
        while (iterator.hasNext()) {
            Svømmer s = iterator.next();
            if (s.medlemID == medlemsID) {
                iterator.remove();
                System.out.println("Medlem med ID " + medlemsID + " er blevet slettet.");
                return; // Når medlemmet er fundet og slettet, afsluttes metoden.
            }
        }
        System.out.println("Medlem med ID " + medlemsID + " blev ikke fundet.");
    }
    public String filGemsvøm(){ //sådan den gemmer svømmer objekt i en fil
            return navn+","+køn+","+alder+","+idBogstav+","+medlemID+","+aktivitetsform+","+tlf+","+restance +","+ tid +","+ dato+","+stævne;
    }

    public int compareTo(Svømmer other) {
        // Sammenlign svømmere baseret på tid
        return Double.compare(this.tid, other.tid);
    }

}