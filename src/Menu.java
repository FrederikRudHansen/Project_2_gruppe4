import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Menu  {
    static BetalingSystem betalingSystem = new BetalingSystem(0,0);
    static Scanner tastaturMenu = new Scanner(System.in);
    static Medlem medlem = new Medlem();
    static boolean run = true;
    static Svømmer svømmerslet = new Svømmer();
    static String filsti = "Medlemmer.txt";
    static String filstisvøm = "Svømmer.txt";

    public static void menu() {
        while (run){
            try {
while (run){

    System.out.println("Velkommen til Delfin Svømmehallen\n");
        System.out.println("1. Betaling");
        System.out.println("2. Medlemmer");
        System.out.println("3. Elite Svømmere");
        System.out.println("4. Afslut\n");
        System.out.print("indtast tal: ");
        int hovedeMenu = tastaturMenu.nextInt();
        int hovedeMenu1;
                    switch (hovedeMenu) {
                        case 1 -> {
                            System.out.println("\n1. Se restance");
                            System.out.println("2. Betal\n");
                            System.out.print("indtast tal: ");
                            hovedeMenu = tastaturMenu.nextInt();

                            switch (hovedeMenu) {
                                case 1:
                                    medlem.visRestance();
                                    break;
                                case 2:
                                    betalingSystem.betalRestance();
                                    break;
                            }
                        }
                        case 2 -> {
                            System.out.println("\n1. Se medlemmer");
                            System.out.println("2. Opret medlem");
                            System.out.println("3. Slet medlem\n");
                            System.out.print("indtast tal: ");
                            hovedeMenu1 = tastaturMenu.nextInt();
                            switch (hovedeMenu1) {
                                case 1:
                                    System.out.println("Kun medlem");
                                    System.out.println(Medlem.medlemmer);
                                    System.out.println("Medlem og Elite svømmer");
                                    System.out.println(Svømmer.svømmer);
                                    break;
                                case 2:
                                    System.out.println("Opret medlem");
                                    medlem.opretMedlem();
                                    break;
                                case 3:
                                    System.out.println("Slet medlem");
                                    System.out.println("Indtast medlems ID for at slette: ");
                                    int sletMedlemsid = tastaturMenu.nextInt();
                                    medlem.sletMedlem(sletMedlemsid);
                                    break;
                            }
                        }
                        case 3 -> {
                            System.out.println("\n1. Se oversigt over alle elite svømmere");
                            System.out.println("2. Top 5 elite Svømmere");
                            System.out.println("3. Opret elite Svømmere");
                            System.out.println("4. Slet elite Svømmer\n");
                            System.out.print("Indtast tal: ");
                            hovedeMenu = tastaturMenu.nextInt();
                            switch (hovedeMenu) {
                                case 1:
                                    System.out.println(Svømmer.svømmer);
                                    break;
                                case 2:
                                    Svømmer tid = new Svømmer();
                                    tid.top5svømmere();
                                    System.out.println(Svømmer.top5svømmer);
                                    break;
                                case 3:
                                    Svømmer svømmer1 = new Svømmer();
                                    svømmer1.opretEliteSvømmer();
                                    break;
                                case 4:
                                    System.out.print("Indtast det ønskede ID:");
                                    int medlemsIDSlet = tastaturMenu.nextInt();
                                    svømmerslet.sletSvømmer(medlemsIDSlet);
                                    break;
                            }
                        }
                        case 4 -> {
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filstisvøm,false))) { //GEMMER SVØMMERE I "Medlemmer.txt" FIL
                                for (Svømmer s : Svømmer.svømmer) {
                                    writer.write(s.filGemsvøm()+ "\n"); // MANGLER LOGIK TIL AT GEMME LISTEN
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filsti,false))) {
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