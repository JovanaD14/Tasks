package drugiZadatak;

public class RekreativniPlaninar extends Planinar{
    private int tezinaOpreme;
    private String okrug;
    private double maxUspon;

    public RekreativniPlaninar(int id, String imeIprezime, int tezinaOpreme, String okrug, double maxUspon) {
        super(id, imeIprezime);
        this.tezinaOpreme = tezinaOpreme;
        this.okrug = okrug;
        this.maxUspon = maxUspon;
    }

    public int getTezinaOpreme() {
        return tezinaOpreme;
    }

    public String getOkrug() {
        return okrug;
    }

    public double getMaxUspon() {
        return maxUspon;
    }

    @Override
    public String uspesanUspon (Planina x){
        String s;
        if ((this.maxUspon - (tezinaOpreme * 50)) >= x.getVisina()){
            s = "Uspesno ce se popeti na planinu.";
        }
        else {s = "Nece uspeti da se popne na planinu.";}
        return s;
    }

    @Override
    public String stampaj() {
        return null;
    }

    @Override
    public double clanarina(){
        return 1000;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rekreativac, id: ").append(getId()).append("\n");
        sb.append("Ime: ").append(getImeIprezime()).append("\n");
        sb.append("Okrug: ").append(getOkrug()).append("\n");
        return sb.toString();
    }



}
