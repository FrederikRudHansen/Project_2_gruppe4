public class Medlem {
    String navn;
    int medlemID;
    int alder;
    String aktivitetsform;
    int restance;
    Medlem (String navn, int medlemID, int alder, String af, int restance){
        this.navn=navn;
        this.medlemID=medlemID;
        this.alder=alder;
        aktivitetsform=af;
        this.restance=restance;
    }
}
