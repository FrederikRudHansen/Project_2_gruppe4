import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Svømmer extends Medlem {

    public static ArrayList<Svømmer> svømmer;
    public static ArrayList<Svømmer> top5svømmer = new ArrayList<Svømmer>();
    public static boolean fastsvømmerprettet = false;
    public static int nextMedlemID = 200;
    public double tid;
    public LocalDate dato;
    String stævne;

        Svømmer(String navn, int alder, String af, int tlf, String køn, double tid, LocalDate dato, String st,int restance) {
            super(navn, alder, af, tlf, køn,restance);
            this.tid = tid;
            this.dato = dato;
            stævne = st;
            this.medlemID = nextMedlemID++;
        }
        Svømmer (){
            if (svømmer == null) {
                svømmer = new ArrayList<>();
            }
            fastsvømmer();

    }

    public double gettid() {
            return this.tid;
    }

    public void fastsvømmer() {
        if (fastsvømmerprettet == false) {
            Svømmer NySvømmer1 = new Svømmer("Goku", 30, "konkurrencesvømmer", 12345678, "Mand", 4.10, LocalDate.of(2023,11,30), "langdistance",0);
            Svømmer NySvømmer2 = new Svømmer("Vegeta", 36, "konkurrencesvømmer", 10010001, "Mand", 4.30, LocalDate.of(2023,11,30), "langdistance",0);
            Svømmer NySvømmer3 = new Svømmer("Piccolo", 55, "konkurrencesvømmer", 66666666, "Mand", 6.05, LocalDate.of(2023,11,30), "langdistance",0);
            Svømmer NySvømmer4 = new Svømmer("Krillin", 29, "konkurrencesvømmer", 69696969, "Mand", 10.55, LocalDate.of(2023,11,30), "langdistance",0);
            Svømmer NySvømmer5 = new Svømmer("Tenshinhan", 31, "konkurrencesvømmer", 21212121, "Mand", 8.33, LocalDate.of(2023,11,30), "langdistance",0);
            svømmer.add(NySvømmer1);
            svømmer.add(NySvømmer2);
            svømmer.add(NySvømmer3);
            svømmer.add(NySvømmer4);
            svømmer.add(NySvømmer5);
            fastsvømmerprettet = true;

            //minimum 3 stævner?
        }
    }
    public void top5svømmere() {
        Collections.sort(svømmer, Comparator.comparing(Svømmer::gettid));
        top5svømmer.clear();
        top5svømmer.addAll(svømmer.subList(0,5));
        }
    @Override
    public String toString() {
        return "Medlem: "+ navn+", "+køn+", "+alder +"\n\nMedlems ID: "+ medlemID +"\n\nAktivitetsform: "+aktivitetsform+"\n\nTelefon: +45" +tlf+
                "\n\nRestance: " +restance+"\n_____________________\n" + "Svømmer:\n" + navn + "\nStævne:\n" + stævne + "\nDato:\n" + dato +
                "\nSluttidspunkt:\n" + tid + "\n_____________________\n";
    }
}
