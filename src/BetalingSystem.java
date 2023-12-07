public class BetalingSystem extends Medlem {
    int balance;
    int reseveretPenge;
    boolean medlemFundet = true;
    BetalingSystem(int bal, int resPenge) {
        balance = bal;
        reseveretPenge = resPenge;
    }

    public void betalRestance() {
        System.out.println("\nBetal Restance\n");
        System.out.println("Indtast dit medlems ID for at se din restance\n");
        int egenMedlemID = tast.nextInt();

        for (Medlem medlem : medlemmer) {
            if (medlem.medlemID == egenMedlemID) {
                System.out.println("\nDin restance er: " + medlem.restance);
                System.out.println("\nIndtast venligst beløbet: ");
                int indbetaling = tast.nextInt();

                try {
                    System.out.print("Beregner resterende beløb");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.println(".");
                    Thread.sleep(1000);
                    int nyRestance = medlem.restance - indbetaling;
                    medlem.setRestance(nyRestance);

                    System.out.println("\nResterende beløb: " + nyRestance );
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