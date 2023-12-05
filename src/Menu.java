import java.util.ArrayList;
import java.util.Scanner;
public class Menu  {

    static Scanner tastaturMenu = new Scanner(System.in);
    static Medlem medlem = new Medlem();
    static boolean run = true;

    public static void menu() {
while (run){
        System.out.println("\nVelkommen til Delfin Svømmehallen\n");
        System.out.println("1. Betaling");
        System.out.println("2. Medlemmer");
        System.out.println("3. Svømmer");
        System.out.println("4. Stævne");
        System.out.println("5. Afslut\n");
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
                switch (hovedeMenu) {
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
                hovedeMenu1 = tastaturMenu.nextInt();
                switch (hovedeMenu1) {
                    case 1:
                        System.out.println(Medlem.medlemmer);
                        bitchTastatur = tastaturMenu.nextLine();
                        break;
                    case 2:
                        System.out.println("Opret medlem");
                        medlem.opretMedlem();
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
                switch (hovedeMenu) {
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
                System.out.println("1. Indtast stævnetid");
                System.out.println("2. Se stævnetider");
                System.out.println("3. Slet deltager fra stævne");
                System.out.println("4. Tilbage til hovedmenuen");
                Scanner scanner = new Scanner(System.in);
                ArrayList<SvømmerInfo> svømmere = new ArrayList<>();
                hovedeMenu = tastaturMenu.nextInt();
                switch (hovedeMenu) {
                    case 1:
                            System.out.println("Udfyld informationer eller skriv afslut for afslut");
                            System.out.print("Fulde navn ");
                            String navn = scanner.nextLine();


                            System.out.print("Konkurrence ");
                            String konkurrence = scanner.nextLine();

                            System.out.print("Placering ");
                            String placering = scanner.nextLine();

                            System.out.print("Stil ");
                            String stil = scanner.nextLine();

                            System.out.print("Tid i sekunder ");
                            double tid = scanner.nextDouble();


                            SvømmerInfo nySvømmerInfo = new SvømmerInfo(navn, konkurrence, placering, stil, tid);
                            svømmere.add(nySvømmerInfo);

                            System.out.println("Informationer gemt");
                            break;


                    case 2:
                        System.out.println("Sammendrag af svømmerinformation:");
                        for (SvømmerInfo svømmer : svømmere) {
                            System.out.println(svømmer);
                        }
                        break;

                    case 3:
                        // Sletning af en deltager
                        System.out.println("Indtast navnet på deltageren, du vil slette: ");
                        String navnAtSlette = tastaturMenu.next();
                        boolean deltagerFundet = false;
                        for (SvømmerInfo Svømmer : svømmere) {
                            if (Svømmer.navn.equals(navnAtSlette)) {
                                svømmere.remove(Svømmer);
                                deltagerFundet = true;
                                System.out.println("Deltageren er slettet.");
                                break;
                            }
                        }
                        if (!deltagerFundet) {
                            System.out.println("Deltageren blev ikke fundet.");
                        }
                        break;
                    case 4:
                        //tilbage til hovedmenuen
                        break;
                    default:
                        System.out.println("Ugyldigt valg");
                        break;
                }
            }
        }

            }
            }
        }


class MenuExc extends Exception{}