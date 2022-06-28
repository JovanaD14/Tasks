public class SastojakRecepta extends Sastojak {

    private double kolicina;

    public SastojakRecepta(String naziv, double cena, double kolicina) {
        super(naziv, cena);
        this.kolicina = kolicina;
    }

    public SastojakRecepta(double kolicina) {
        this.kolicina = kolicina;
    }

    public SastojakRecepta() {
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double ukupnaCena(){
        return super.getCena()*this.kolicina;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Potrebna kolicina sastojka (mililitar / gram / komad) je: ").append(kolicina);
        sb.append("\nUkupna cena za ovaj sastojak je ").append(ukupnaCena());
        sb.append("\n--------------------");
        return sb.toString();
    }
}
