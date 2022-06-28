package prviZadatak;

public class Vozac extends Covek{
    private String zvanje;

    public Vozac(String ime, String prezime) {
        super(ime, prezime);
        this.zvanje = "sofer";
    }

    public Vozac() {
        this.zvanje = "sofer";
    }

    public String getZvanje() {
        return zvanje;
    }
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("Vozac: ").append(getIme()).append(" ").append(getPrezime());
        return sb.toString();
    }
}
