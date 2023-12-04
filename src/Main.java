import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        FilLæser filLæser = new FilLæser();
        filLæser.LæsMedlemFil(Medlem.medlemmer);

        Menu.menu();

    }
}
