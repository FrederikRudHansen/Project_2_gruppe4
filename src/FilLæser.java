import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FilLæser {

    public void LæsMedlemFil(ArrayList<Medlem> medlemmer) {
        String fil = "Medlemmer.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fil))) {
            String linje;
            while ((linje = br.readLine()) != null) {
                behandlData(medlemmer, linje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public static void behandlData(ArrayList<Medlem> medlemmer, String line) {
        String[] del = line.split(",");
        if (del.length == 8) {
            String navn = del[0].trim();
            String køn = del[1].trim();
            int alder = Integer.parseInt(del[2].trim());
            String idBogstav = del[3].trim();
            int medlemID = Integer.parseInt(del[4].trim());
            String aktivitetsform = del[5].trim();
            int tlf = Integer.parseInt(del[6].trim());
            int restance = Integer.parseInt(del[7].trim());

            Medlem nyMedlem = new Medlem(navn, alder, aktivitetsform, tlf, køn, restance);
            nyMedlem.medlemID = medlemID;
            nyMedlem.IdBogstav = idBogstav;
            medlemmer.add(nyMedlem);
        } else {
            System.out.println("Ugyldig data: " + line);
        }
    }
    public static void behandlDataSvøm(ArrayList<Svømmer> svømmer, String line) {
        String[] del = line.split(",");
        if (del.length == 11) {
            String navn = del[0].trim();
            String køn = del[1].trim();
            int alder = Integer.parseInt(del[2].trim());
            String idBogstav = del[3].trim();
            int medlemID = Integer.parseInt(del[4].trim());
            String aktivitetsform = del[5].trim();
            int tlf = Integer.parseInt(del[6].trim());
            int restance = Integer.parseInt(del[7].trim());
            double tid = Double.parseDouble(del[8].trim());
            LocalDate dato = LocalDate.parse(del[9].trim());
            String stævne = del[10].trim();



            Svømmer nySvømmer = new Svømmer(navn, alder, aktivitetsform, tlf, køn, tid, dato, stævne, restance);
            nySvømmer.medlemID = medlemID;
            nySvømmer.IdBogstav = idBogstav;
            svømmer.add(nySvømmer);
        } else {
            System.out.println("Ugyldig data: " + line);
        }
    }
    public void LæsMedlemFilSvøm(ArrayList<Svømmer> svømmer) {
        String fil = "Svømmer.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fil))) {
            String linje;
            while ((linje = br.readLine()) != null) {
                behandlDataSvøm(svømmer, linje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
