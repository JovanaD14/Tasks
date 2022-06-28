import java.util.ArrayList;

public class Recept {
    private String naziv;
    private int tezina;
    private ArrayList<SastojakRecepta> potrebniSastojci;

    public Recept(String naziv, int tezina, ArrayList<SastojakRecepta> potrebniSastojci) {
        this.naziv = naziv;
        this.tezina = tezina;
        this.potrebniSastojci = potrebniSastojci;
    }

    public Recept() {
        this.naziv = "";
        this.tezina = 0;
        this.potrebniSastojci = new ArrayList<>();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public ArrayList<SastojakRecepta> getPotrebniSastojci() {
        return potrebniSastojci;
    }

    public void setPotrebniSastojci(ArrayList<SastojakRecepta> potrebniSastojci) {
        this.potrebniSastojci = potrebniSastojci;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.naziv).append(": \n");
        sb.append("Tezina: ");
        switch (this.tezina){
            case 1:
                sb.append("Pocetni nivo");
                break;
            case 2:
                sb.append("Lak nivo");
                break;
            case 3:
                sb.append("Srednji nivo");
                break;
            case 4:
                sb.append("Tezak nivo");
                break;
            case 5:
                sb.append("Majstorski nivo");
                break;
            }
        sb.append("\nSastojci: \n");
        for (SastojakRecepta s: potrebniSastojci){
            sb.append("-").append(s.getNaziv()).append("\n");
            }
        return sb.toString();
        }
    public void dodajSastojak (SastojakRecepta x) {
        potrebniSastojci.add(x);
    }
    public void ukloniSastojak (SastojakRecepta x){
        for (int i = 0; i < potrebniSastojci.size() ; i++) {
            SastojakRecepta trenutni = potrebniSastojci.get(i);
            if (trenutni.getNaziv().equals(x.getNaziv()) && (trenutni.getCena()==x.getCena())&& (trenutni.getKolicina()==x.getKolicina())){
                potrebniSastojci.remove(i);
                return;
            }
        }
    }
}
            



