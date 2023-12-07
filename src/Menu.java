import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Menu  {
    static BetalingSystem betalingSystem = new BetalingSystem();
    static Scanner tastaturMenu = new Scanner(System.in);
    static Medlem medlem = new Medlem();
    static boolean run = true;
    static Svømmer svømmerslet = new Svømmer();
    static String filsti = "Medlemmer.txt";
    static String filstiSvøm = "Svømmer.txt";

    public static void menu() {
        while (run){
            try {
while (run){

    System.out.println("Velkommen til Delfin Svømmehallen\n"); //start skærmen når menuen starter
        System.out.println("1. Betaling");
        System.out.println("2. Medlemmer");
        System.out.println("3. Elite Svømmere");
        System.out.println("4. Afslut\n");
        System.out.print("indtast tal: ");
        int hovedeMenu = tastaturMenu.nextInt();
        int hovedeMenu1;
                    switch (hovedeMenu) { //betaling
                        case 1 -> {
                            System.out.println("\n1. Se restance");
                            System.out.println("2. Betal\n");
                            System.out.print("indtast tal: ");
                            hovedeMenu = tastaturMenu.nextInt();

                            switch (hovedeMenu) {
                                case 1: //oversigt over medlemmer og deres Restance
                                    medlem.visRestance();
                                    break;
                                case 2: //betal deres restance via. deres ID
                                    betalingSystem.betalRestance();
                                    break;
                            }
                        }
                        case 2 -> { //Medlemmer
                            System.out.println("\n1. Se medlemmer");
                            System.out.println("2. Opret medlem");
                            System.out.println("3. Slet medlem\n");
                            System.out.print("indtast tal: ");
                            hovedeMenu1 = tastaturMenu.nextInt();
                            switch (hovedeMenu1) {
                                case 1://Viser oversigt over medlemmer
                                    System.out.println("Kun medlem");
                                    System.out.println(Medlem.medlemmer);
                                    System.out.println("Medlem og Elite svømmer");
                                    System.out.println(Svømmer.svømmer);
                                    break;
                                case 2://opret medlem
                                    System.out.println("Opret medlem");
                                    medlem.opretMedlem();
                                    break;
                                case 3://slet medlem
                                    System.out.println("Slet medlem");
                                    System.out.println("Indtast medlems ID for at slette: ");
                                    int sletMedlemsid = tastaturMenu.nextInt();
                                    medlem.sletMedlem(sletMedlemsid);
                                    break;
                            }
                        }
                        case 3 -> {//Elite Svømmer
                            System.out.println("\n1. Se oversigt over alle elite svømmere");
                            System.out.println("2. Top 5 elite Svømmere");
                            System.out.println("3. Opret elite Svømmere");
                            System.out.println("4. Slet elite Svømmer\n");
                            System.out.print("Indtast tal: ");
                            hovedeMenu = tastaturMenu.nextInt();
                            switch (hovedeMenu) {
                                case 1://oversigt over kun Elite svømmere (til træneren self)
                                    System.out.println(Svømmer.svømmer);
                                    break;
                                case 2://top 5 over de hurtigeste svømmere
                                    Svømmer tid = new Svømmer();
                                    tid.top5svømmere();
                                    System.out.println(Svømmer.svømmer);
                                    break;
                                case 3://opret en svømmer og deres konkurence med hvor hurtig de er.
                                    Svømmer svømmer1 = new Svømmer();
                                    svømmer1.opretEliteSvømmer();
                                    break;
                                case 4: // slet elite svømmer
                                    System.out.print("Indtast det ønskede ID:");
                                    int medlemsIDSlet = tastaturMenu.nextInt();
                                    svømmerslet.sletSvømmer(medlemsIDSlet);
                                    break;
                            }
                        }
                        case 4 -> {//Afslut

                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filstiSvøm,false))) { //GEMMER SVØMMERE I "Medlemmer.txt"
                                for (Svømmer s : Svømmer.svømmer) {
                                    writer.write(s.filGemsvøm()+ "\n"); // MANGLER LOGIK TIL AT GEMME LISTEN
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filsti,false))) { //gemmer alle medlemmer i ArrayListen
                                for (Medlem m : Medlem.medlemmer) {
                                    writer.write(m.filGem() + "\n");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            run = false;
                        }
                    }
                }
            } catch(Exception e){
                System.out.println("Ugyldig input");
                tastaturMenu.nextLine();
            }
        }
    }
}