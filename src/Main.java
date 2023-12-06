import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws InterruptedException {




        FilLæser filLæser = new FilLæser();
        filLæser.LæsMedlemFil(Medlem.medlemmer);

        ProgressBar showprogressbar = new ProgressBar();


        for (int i = 0; i <= 100; i++) {
            ProgressBar.showProgressBar(100,i);
            Thread.sleep(75);
        }
        System.out.println("\u001B[2;30;40m\u001B[32mProgress: [==================================================] 100%\u001B[0m");


        Menu.menu();

    }
}
