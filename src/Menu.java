import java.util.Scanner;
public class Menu  {

    static Scanner tastaturMenu = new Scanner(System.in);
    static Medlem medlem = new Medlem();
    static boolean run = true;

    public static void menu() {
while (run){
        System.out.println("Velkommen til Delfin Svømmehallen\n");
        System.out.println("1. Betaling");
        System.out.println("2. Medlemmer");
        System.out.println("3. Svømmer");
        System.out.println("4. Afslut\n");
        System.out.print("indtast tal:");
        int hovedeMenu = tastaturMenu.nextInt();
        int hovedeMenu1;
        String bitchTastatur;



        switch (hovedeMenu) {
            case 1 -> {
                System.out.println("\n1. Se restance");
                System.out.println("2. Betal\n");
                System.out.print("indtast tal:");
                hovedeMenu = tastaturMenu.nextInt();
                switch (hovedeMenu){
                    case 1:
                        //Se restance metode//
                    case 2:
                        //Betal metode//
                        hovedeMenu = tastaturMenu.nextInt();
                }
            }
            case 2 -> {
                System.out.println("\n1. Se meldemmer");
                System.out.println("2. Opret medlem");
                System.out.println("3. Slet medlem\n");
                System.out.println("4. Slet svømmeres deltagelse i en konkurrence");
                System.out.print("indtast tal:");
                hovedeMenu1 = tastaturMenu.nextInt();
                switch (hovedeMenu1){
                    case 1:
                        System.out.println(Medlem.medlemmer);
                        bitchTastatur = tastaturMenu.nextLine();
                        break;
                    case 2:
                        System.out.println("Opret medlem");
                        medlem.opretMedlem();
                        break;
                    case 3:
                        System.out.println("Slet medlem");
                        System.out.println("Indtast medlems ID for at slette:");
                        int sletMedlemsid = tastaturMenu.nextInt();
                        medlem.sletMedlem(sletMedlemsid);
                        break;
                    case 4:
                        System.out.println("Slet svømmerens deltagelse i konkurrence");
                        System.out.println("Indtast konkurrence-ID:");
                        int konkurrenceIDAtSlette = tastaturMenu.nextInt();
                        System.out.println("Indtast medlems-ID for svømmeren:");
                        int medlemsIDAtSletteDeltagelse = tastaturMenu.nextInt();
                        medlem.sletDeltagelse(konkurrenceIDAtSlette, medlemsIDAtSletteDeltagelse);
                        break;
                }
            }

            case 3 -> {
                System.out.println("\n1. Se oversigt over alle");
                System.out.println("2. Top 5 svømmere");
                System.out.println("3. Opret svømmer");
                System.out.println("4. Slet svømmer\n");
                System.out.print("indtast tal:");
                hovedeMenu = tastaturMenu.nextInt();
                switch (hovedeMenu){
                    case 1:
                        //Se oversigt over alle//
                    case 2:
                        //Top 5 Svømmere metode//
                    case 3:
                        //Opret svømmer metode//
                    case 4:
                        //Slet svømmer metdoe//
                }
            }
            case 4 -> {
                run=false;
            }
            }
        }
    }
}
class MenuExc extends Exception{}