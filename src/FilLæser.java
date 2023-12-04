import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FilLæser {

    public void LæsMedlemFil(ArrayList<Medlem> medlemmer){
        String fil = "Medlemmer.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fil))){
            String linje;
            while ((linje = br.readLine()) != null) {
                if (linje.equals("_____________________")) {
                } else {
                    behandlData(medlemmer,linje);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void behandlData (ArrayList<Medlem> medlemmer, String line){
        String[] del = line.split(": ");
        if (del.length==2){
            String attribut = del[0].trim();
            String værdi = del[1].trim();

            if (attribut.equals("Medlem")){
                Medlem nyMedlem = new Medlem();
                nyMedlem.setNavn(værdi);
                medlemmer.add(nyMedlem);
            }else{
                System.out.println("???");
            }
        }
    }
}
