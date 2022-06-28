package prviZadatak;

public class Putnik extends Covek{
    private double kolicinaNovca;

    public Putnik(String ime, String prezime, double kolicinaNovca) {
        super(ime, prezime);
        this.kolicinaNovca = kolicinaNovca;
    }

    public Putnik(double kolicinaNovca) {
        this.kolicinaNovca = kolicinaNovca;
    }

    public Putnik() {
    }

    public double getKolicinaNovca() {
        return kolicinaNovca;
    }

    public void setKolicinaNovca(double kolicinaNovca) {
        this.kolicinaNovca = kolicinaNovca;
    }

    public double dodavanjeNovca (double x){
        return kolicinaNovca + x;
    }
    public double oduzimanjeNovca (double x){
        return kolicinaNovca - x;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getIme()).append(" ").append(getPrezime());
        return sb.toString();
    }
    }

