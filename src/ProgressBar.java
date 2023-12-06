public class ProgressBar {
    public static void main(String[] args) throws InterruptedException {


    }
    public static void showProgressBar(int total, int current) throws InterruptedException {

    int progress = (current * 100) / total;
    String fremgang = "\u001B[2;30;40m\u001B[31mProgress: "+ "[" + "=".repeat(progress / 2) + "] " + progress + "%\u001B[0m\r";
    System.out.print(fremgang);

}


}
