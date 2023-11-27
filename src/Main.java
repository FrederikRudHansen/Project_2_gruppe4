public class Main {
    public static void main(String[] args) {
        Medlem medlem1 = new Medlem("Gabe Horn", 765, "tittysvømning",1000);
        Medlem medlem2 = new Medlem("Sam Sung",100, "Dick stuck in blender", 1200);
        Medlem medlem3 = new Medlem("Jeremy Updog",221,"KAN IKKE SVØMME",1800);
        Medlem medlem4 = new Medlem("Ole Wedel", 301, "Butterfly", 0);
        System.out.println(medlem1.medlemID + " " + medlem1.navn);
        Menu.menu();
    }
}