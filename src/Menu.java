import java.util.Scanner;

public class Menu {

    static Scanner tastaturMenu = new Scanner(System.in);
    public static void menu() {

        System.out.println("Velkommen til Delfin Svømmehallen\n");
        System.out.println("1. Betaling");
        System.out.println("2. Medlemmer");
        System.out.println("3. Svømmer\n");

        System.out.print("indtast tal:");

        int hovedeMenu = tastaturMenu.nextInt();

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
                System.out.print("indtast tal:");
                hovedeMenu = tastaturMenu.nextInt();

                switch(hovedeMenu){
                    case 1:
                        System.out.println("Medlem 1: " );
                    case 2: //opret medlem metode//
                    case 3: //Slet medlem metode//
                        hovedeMenu = tastaturMenu.nextInt();
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
                        //Top 5 Svømmere metode//
                    case 2:
                        //Opret svømmer metode//
                    case 3:
                        //Slet svømmer metdoe//
                }
            }
        }


    }
}
class MenuExc extends Exception{

}
