import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Svømmer extends Medlem {

    public static ArrayList<Svømmer> svømmer = new ArrayList<>();
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
            Svømmer NySvømmer1 = new Svømmer("Goku", 30, "Elite Svømmer", 12345678, "Mand", 4.10, LocalDate.of(2023,11,30), "langdistance",restance);
            Svømmer NySvømmer2 = new Svømmer("Vegeta", 36, "Elite Svømmer", 10010001, "Mand", 4.30, LocalDate.of(2023,11,30), "langdistance",restance);
            Svømmer NySvømmer3 = new Svømmer("Piccolo", 55, "Elite Svømmer", 66666666, "Mand", 6.05, LocalDate.of(2023,11,30), "langdistance",restance);
            Svømmer NySvømmer4 = new Svømmer("Krillin", 29, "Elite Svømmer", 69696969, "Mand", 10.55, LocalDate.of(2023,11,30), "langdistance",restance);
            Svømmer NySvømmer5 = new Svømmer("Tenshinhan", 31, "Elite Svømmer", 21212121, "Mand", 8.33, LocalDate.of(2023,11,30), "langdistance",restance);
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
        return "Medlem: "+ navn+", "+køn+", "+alder +"\n\nMedlems ID: "+ medlemID +"\n\nSluttidspunkt: " + tid +"\n\nDisciplin: "+aktivitetsform+ "\n\nStævne: " + stævne + "\n\nDato: " + dato +
                "\n\nTelefon: +45" +tlf+"\n\nRestance: " +restance+"\n_____________________\n";
    }
    public void opretEliteSvømmer(){
        System.out.println("\n Elite Svømmere ⇩\n");
        System.out.println("Indtast navn");
        navn = tast.nextLine();
        System.out.println("Indtast køn");
        køn = tast.nextLine();
        if (køn.equalsIgnoreCase("Mand") || køn.equalsIgnoreCase("kvinde")) {
            System.out.println("Indtast alder");
            int alder = Alderberegning.beregnAlder();

            int restance;
            if (alder < 18) {
                restance = +1000;
            } else {
                restance = +1600;
            }
            System.out.println("Indtast disciplin");
            String dp = tast.nextLine();
            System.out.println("Indtast stævne");
            stævne = tast.nextLine();
            System.out.println("Indtast bedste tid");
            double tid = tast.nextDouble();
            System.out.println("Indtast dato for bedste tid [dd-MM-yyyy]");

            tast.nextLine();
            String datoString = tast.nextLine();
            DateTimeFormatter datoFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dato = LocalDate.parse(datoString,datoFormatter);


            System.out.println("Indtast Telefon nummer");
            int tlf = Integer.parseInt(tast.nextLine());
            Svømmer nySvømmer = new Svømmer(navn,alder,dp,tlf,køn,tid,dato,stævne,restance);
            svømmer.add(nySvømmer);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filsti))) { //GEMMER SVØMMERE I "Medlemmer.txt" FIL
                writer.write(nySvømmer.toString()); // MANGLER LOGIK TIL AT GEMME LISTEN
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Menu.menu();
        } else {
            System.out.println("not a køn stupid");
        }
    }
}
