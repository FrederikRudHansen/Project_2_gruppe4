import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws InterruptedException {

        FilLæser filLæser = new FilLæser();
        filLæser.LæsMedlemFil(Medlem.medlemmer);
        filLæser.LæsMedlemFilSvøm(Svømmer.svømmer);

        for (int i = 0; i <= 100; i++) { //lille loading progress bar, der starter når programmet starter
            ProgressBar.showProgressBar(100,i);
            Thread.sleep(25);
        }
        // Sout nedenunder her, viser når progress baren er færdig
        System.out.println("\u001B[2;30;40m\u001B[32mProgress: [==================================================] 100%\u001B[0m");
        Menu.menu(); //her starter menuen
    }
}
