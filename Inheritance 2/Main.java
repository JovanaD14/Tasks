package drugiZadatak;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Planina p = new Planina("Stara planina", "Srbija", 2376);
        Planinar r = new RekreativniPlaninar(156, "Marija Peric",20,"Kolubarski",1700);
        Planinar r1 = new RekreativniPlaninar(337, "Uros Jokic",12, "Sremski", 2000);
        Planinar r2 = new RekreativniPlaninar(561, "Jelena Maric",20,"Raski",3500);
        Planinar a = new Alpinista(222,"Milena Dinic",5);
        Planinar a1 = new Alpinista(123,"Jovana Ralic",10);
        Planinar a2 = new Alpinista(256,"Petar Peric",10);
        ArrayList<Planinar> lista =new ArrayList<>();
        lista.add(r);
        lista.add(r1);
        lista.add(r2);
        lista.add(a);
        lista.add(a1);
        lista.add(a2);

        for (int i = 0; i < lista.size() ; i++) {
            System.out.println(lista.get(i));
            System.out.println(lista.get(i).uspesanUspon(p));
            System.out.println("----------------------------");
        }

        double suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma = suma + lista.get(i).clanarina();
        }
        System.out.println();
        System.out.println("Zbir clanarina svih planinara je " + suma);

    }
}
