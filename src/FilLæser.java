import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    private static void behandlData(ArrayList<Medlem> medlemmer, String line) {
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
}
