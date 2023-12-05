public class BetalingSystem extends Medlem {
    int balance;
    int reseveretPenge;

    BetalingSystem(int bal, int resPenge) {
        balance = bal;
        reseveretPenge = resPenge;
    }

    public void betalRestance() {
        System.out.println("\nBetal Restance\n");
        System.out.println("Indtast dit medlems ID for at se din restance\n");
        int egenMedlemID = Integer.parseInt(tast.nextLine());

        for (Medlem medlem : medlemmer) {
            if (medlem.medlemID == egenMedlemID) {
                System.out.println("\nDin restance er: " + medlem.restance);
                System.out.println("\nIndtast venligst beløbet: ");
                double indbetaling = tast.nextDouble();

                try {
                    Thread.sleep(1000);
                    System.out.print("Beregner resterende beløb");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);         //DRAMATISK EFFEKT. SLET HVIS IRRITERENDE
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.println(".");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                    System.out.println("\nResterende beløb: " + restance-- + indbetaling);
                    return;
                }
            }
            System.out.println(+egenMedlemID + " er et ugyldigt ID");   //KAN IKKE TAGE ID / VI SKAL LAVE ID OM TIL NOGET DEN KAN TAGE
            return;
        }
    }
}