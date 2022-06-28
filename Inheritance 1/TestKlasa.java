package prviZadatak;

import java.util.ArrayList;

public class TestKlasa {
    public static void main(String[] args) {

        Covek c = new Covek("Petar", "Jovic");
        Putnik p = new Putnik(c.getIme(), c.getPrezime(), 600.0);
        Putnik p1 = new Putnik("Jelena", "Lolic", 200);
        Putnik p2 = new Putnik(500);
        Putnik p3 = new Putnik();
        ArrayList<Putnik> putnici = new ArrayList<>();
        Vozac v = new Vozac("Nenad", "Peric");
        Vozac v1 = new Vozac();
        Autobus a = new Autobus("Autobus1", 200);
        a.setVozacAutobusa(v);
        a.setVozacAutobusa(v1);
        a.setVozacAutobusa(v);
        a.setPutnici(putnici);
        a.dodajPutnika(p);
        a.dodajPutnika(p1);
        a.dodajPutnika(p2);
        a.dodajPutnika(3,p3);
        a.ukloniPutnika(p);
        System.out.println(a);

    }
}