import java.util.Scanner;

public class Menu {

    static Scanner tastaturMenu = new Scanner(System.in);
    public static void menu() {

        System.out.println("Velkommen til Delfin Svømmehallen\n");
        System.out.println("1. Betaling");
        System.out.println("2. Medlemmer");
        System.out.println("3. Svømmer");

        System.out.print("indtast tal:");

        int hovedeMenu = tastaturMenu.nextInt();

        switch (hovedeMenu) {
            case 1:
                System.out.println("\n1. Se restance");
                System.out.println("2. Betal");
                System.out.print("indtast tal:");
                hovedeMenu = tastaturMenu.nextInt();
                break;
            case 2:
                System.out.println("\n1. Se oversigt");
                System.out.println("2. Opret medlem");
                System.out.println("3. Slet medlem");
                System.out.print("indtast tal:");
                hovedeMenu = tastaturMenu.nextInt();
                break;
            case 3:
                System.out.println("\n1. Se oversigt over alle");
                System.out.println("2. Top 5 svømmere");
                System.out.println("3. Opret svømmer");
                System.out.println("4. Slet svømmer");
                System.out.print("indtast tal:");
                hovedeMenu = tastaturMenu.nextInt();
                break;
        }


    }
}
class MenuExc extends Exception{

}
