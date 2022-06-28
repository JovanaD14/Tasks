package drugiZadatak;

public class Alpinista extends Planinar {
    private int poeni;

    public Alpinista(int id, String imeIprezime, int poeni) {
        super(id, imeIprezime);
        this.poeni = poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public int getPoeni() {
        return poeni;
    }
    @Override
    public String stampaj() {
        return null;
    }


    @Override
    public double clanarina() {
        return 1500 - (poeni * 50);
    }

    @Override
    public String uspesanUspon(Planina x) {
        String s;
        if(x.getVisina() < 4000){
            s = "Uspesno ce se popeti na planinu.";
        }
        else {s = "Nece uspeti da se popenje na planinu.";}
        return s;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alpinista, id: ").append(getId()).append("\n");
        sb.append("Ime: ").append(getImeIprezime()).append("\n");
        sb.append("Broj poena: ").append(poeni).append("\n");
        return sb.toString();

    }
}
