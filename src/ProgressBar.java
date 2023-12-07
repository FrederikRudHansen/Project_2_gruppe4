public class ProgressBar {
    public static void showProgressBar(int total, int current) throws InterruptedException {
// hvordan progress baren virker
    int progress = (current * 100) / total;
    String fremgang = "\u001B[2;30;40m\u001B[31mProgress: "+ "[" + "=".repeat(progress / 2) + "] " + progress + "%\u001B[0m\r"; // den første backslash er til bagrunden andet backslah er farve på teksten tredje er reset
    System.out.print(fremgang);
    }
}