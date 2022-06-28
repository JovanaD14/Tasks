package prviZadatak;

import java.util.ArrayList;

public class Autobus {
    private String naziv;
    private double cenaKarte;
    private Vozac vozacAutobusa;
    private ArrayList<Putnik> putnici;

    public Autobus(String naziv, double cenaKarte, Vozac vozacAutobusa, ArrayList<Putnik> putnici) {
        this.naziv = naziv;
        this.cenaKarte = cenaKarte;
        this.vozacAutobusa = vozacAutobusa;
        this.putnici = putnici;
    }
    public Autobus (String naziv, double cenaKarte){
        this.naziv = naziv;
        this.cenaKarte = cenaKarte;
    }
    public Autobus() {
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCenaKarte() {
        return cenaKarte;
    }


    public Vozac getVozacAutobusa() {
        return vozacAutobusa;
    }

    public void setVozacAutobusa(Vozac vozacAutobusa) {
        this.vozacAutobusa = vozacAutobusa;
    }

    public ArrayList<Putnik> getPutnici() {
        return putnici;
    }

    public void setPutnici(ArrayList<Putnik> putnici) {
        this.putnici = putnici;
    }

    public void dodajPutnika(Putnik p) {
        putnici.add(p);
    }

    public void dodajPutnika(int index, Putnik p) {
        putnici.add(index, p);
    }

    public boolean daLiSuIstiPutnici(Putnik p2) {
        for (Putnik p : putnici) {
            if (p.getIme().equalsIgnoreCase(p2.getIme())
                    && p.getPrezime().equalsIgnoreCase(p2.getPrezime())) {
                return true;
            }

        }
        return false;
    }

    public void ukloniPutnika(Putnik p2) {
        if (daLiSuIstiPutnici(p2)) {
            putnici.remove(p2);
        }
    }

    public void ukloniPutnikaDrugiNacin(Putnik p2) {
        if (daLiSuIstiPutnici(p2)) {
            putnici.remove(putnici.indexOf(p2));
        }
    }
    public void ukloniPutnika (int index){
        putnici.remove(index);
    }

    /* Posto se ne radi o listi vozaca (tako sam protumacila tekst), ovde ce
       za dodavanje - uklanjanje novog vozaca biti dovoljna klasicna set metoda. */

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.vozacAutobusa);
        sb.append(". \nU ovom autobusu prevoze se sledeci putnici: ").append(getPutnici());
        sb.append(". \nCena karte iznosi ").append(this.cenaKarte).append(" dinara.");
        return sb.toString();
    }

}