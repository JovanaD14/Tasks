import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Sastojak prvi = new Sastojak("jaje",10);
        Sastojak drugi = new Sastojak("mleko", 0.15);
        Sastojak treci = new Sastojak("brasno", 0.1);
        Sastojak cetvrti = new Sastojak();
        System.out.println(drugi);
        SastojakRecepta a = new SastojakRecepta(prvi.getNaziv(), prvi.getCena(),2 );
        SastojakRecepta b = new SastojakRecepta(drugi.getNaziv(), drugi.getCena(), 200);
        SastojakRecepta c = new SastojakRecepta(200);
        SastojakRecepta d = new SastojakRecepta();
        d.setNaziv("Mineralna voda");
        d.setCena(0.06);
        d.setKolicina(150);
        SastojakRecepta e = new SastojakRecepta("ulje", 0.2, 8);
        System.out.println(c.getKolicina());
        System.out.println(c.getNaziv());
        c.setKolicina(220);
        c.setNaziv(treci.getNaziv());
        c.setCena(treci.getCena());
        System.out.println(c);
        System.out.println(b);
        ArrayList<SastojakRecepta> lista1 = new ArrayList<>();
        lista1.add(a);
        lista1.add(b);
        lista1.add(c);
        lista1.add(d);
        Recept palacinke = new Recept("Palacinke",1,lista1);
        System.out.println(palacinke.toString());
        palacinke.dodajSastojak(e);
        System.out.println(palacinke);
        palacinke.ukloniSastojak(a);
        System.out.println("-----------------");
        System.out.println(palacinke);
        Recept sladoled = new Recept();
        sladoled.setNaziv("Sladoled");
        sladoled.setTezina(1);
        System.out.println(sladoled.getNaziv());
        System.out.println(sladoled.getTezina());
        ArrayList<SastojakRecepta> lista2 = new ArrayList<>();
        SastojakRecepta maline = new SastojakRecepta("maline",0.5,500);
        SastojakRecepta secer = new SastojakRecepta();
        secer.setNaziv("Secer");
        SastojakRecepta jogurt = new SastojakRecepta("jogurt",0.15,300);
        sladoled.setPotrebniSastojci(lista2);
        lista2.add(maline);
        lista2.add(jogurt);
        System.out.println(sladoled.getPotrebniSastojci().size());
        sladoled.ukloniSastojak(maline);
        System.out.println(sladoled.getPotrebniSastojci().size());
        sladoled.dodajSastojak(maline);
        System.out.println(sladoled);
    }

}
