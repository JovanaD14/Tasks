package drugiZadatak;

public abstract class Planinar {
    private int id;
    private String imeIprezime;

    public Planinar(int id, String imeIprezime) {
        this.id = id;
        this.imeIprezime = imeIprezime;
    }

    public int getId() {
        return id;
    }

    public String getImeIprezime() {
        return imeIprezime;
    }

    public abstract String stampaj();
    public abstract double clanarina();
    public abstract String uspesanUspon(Planina x);
}
