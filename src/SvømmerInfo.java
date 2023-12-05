import java.util.ArrayList;
import java.util.Scanner;

class SvømmerInfo {
    String navn;
    String konkurrence;
    String placering;
    String stil;
    double tid;

    public SvømmerInfo(String navn, String konkurrence, String placering, String stil, double tid) {
        this.navn = navn;
        this.konkurrence = konkurrence;
        this.placering = placering;
        this.stil = stil;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Svømmer: " + navn +
                "\nKonkurrence: " + konkurrence +
                "\nPlacering: " + placering +
                "\nStil: " + stil +
                "\nTid: " + tid;
    }
}