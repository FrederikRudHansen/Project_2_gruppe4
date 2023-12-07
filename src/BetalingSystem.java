public class BetalingSystem extends Medlem {

    boolean medlemFundet = true; //bruges til hvis medlem ikke bliver fundet så skriver den ugyldig ID




    public void betalRestance() { //Betaler restance
        System.out.println("\nBetal Restance\n");
        System.out.println("Indtast dit medlems ID for at se din restance\n");
        int egenMedlemID = tast.nextInt();

        for (Medlem medlem : medlemmer) {
            if (medlem.medlemID == egenMedlemID) {
                System.out.println("\nDin restance er: " + medlem.restance);
                System.out.println("\nIndtast venligst indbetalingsbeløbet: ");
                int indbetaling = tast.nextInt();

                try { //Loading til at give den lidt visuelt
                    System.out.print("Beregner resterende beløb");
                    Thread.sleep(700);
                    System.out.print(".");
                    Thread.sleep(700);
                    System.out.print(".");
                    Thread.sleep(700);
                    System.out.println(".");
                    Thread.sleep(700);
                    int nyRestance = medlem.restance - indbetaling;
                    medlem.setRestance(nyRestance); //opdaterer restance

                    System.out.println("\nResterende beløb: " + nyRestance +"\n\n" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        if (!medlemFundet) {
            System.out.println(egenMedlemID + " er et ugyldigt ID");
        }
    }
}