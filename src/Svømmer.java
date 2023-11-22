import java.time.LocalDate;

public class Svømmer {
    double tid;
    LocalDate dato;
    String discipliner;

    Svømmer(double tid, String dp, LocalDate dato){
        this.tid = tid;
        this.discipliner=dp;
        this.dato=dato;

    }

}
