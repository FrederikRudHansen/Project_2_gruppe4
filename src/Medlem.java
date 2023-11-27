public class Medlem {


    @Override
    public String toString() {
        return "Medlem" +
                "Navn='" + navn + '\'' +
                ", MedlemID=" + medlemID +
                ", Alder=" + alder +
                ", Aktivitetsform='" + aktivitetsform + '\'' +
                ", Restance=" + restance;

    }
    private static int nextMedlemID=1000;

    String navn;
    int medlemID;
    int alder;
    String aktivitetsform;
    int restance;
    Medlem (String navn, int alder, String af, int restance){
        this.navn=navn;
        this.medlemID=nextMedlemID++;
        this.alder=alder;
        aktivitetsform=af;
        this.restance=restance;
    }
}
