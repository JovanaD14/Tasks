import java.util.Scanner;

public class NizoviZadatak {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Unesite broj figura igrača 1: ");

        int n1 =sc.nextInt();

        String[] igrac1 = new String[n1];

        System.out.print("Unesite imena figura igraca 1: ");

        for (int i = 0; i <= n1-1 ; i++) {

            igrac1[i] = sc.next();

            if (!(igrac1[i].toUpperCase().contains("KRALJICA") || igrac1[i].toUpperCase().contains("KONJ")
                    || igrac1[i].toUpperCase().contains("LOVAC") || igrac1[i].trim().equalsIgnoreCase("top")
                    || igrac1[i].toLowerCase().contains("pesak") || igrac1[i].toLowerCase().contains("pešak"))){

                     System.out.println("Unesite ispravno ime figure.");
                     igrac1[i] = sc.next();
            }
        }

        System.out.print("Unesite broj figura igrača 2: ");

        int n2 =sc.nextInt();

        String[] igrac2 = new String[n2];

        System.out.print("Unesite imena figura igraca 2: ");

        for (int i = 0; i <= n2-1 ; i++) {

            igrac2[i] = sc.next();

            if (!(igrac2[i].toUpperCase().contains("KRALJICA") || igrac2[i].toUpperCase().contains("KONJ")
                    || igrac2[i].toUpperCase().contains("LOVAC") || igrac2[i].trim().equalsIgnoreCase("top")
                    || igrac2[i].toLowerCase().contains("pesak") || igrac2[i].toLowerCase().contains("pešak"))){

                     System.out.println("Unesite ispravno ime figure.");
                     igrac2[i] = sc.next();
            }
        }

        int suma1 =0;

        for (int i = 0; i <= n1-1 ; i++) {

          if (igrac1[i].trim().toUpperCase().charAt(1) == 'R') {
                  suma1 = suma1 + 12;
                }
          else if (igrac1[i].toLowerCase().contains("pe")){
                  suma1 = suma1 + 1;
               }
          else if (igrac1[i].toUpperCase().contains("KONJ") || igrac1[i].toUpperCase().contains("LOVAC")){
                  suma1 = suma1 + 3;
              }
          else if (igrac1[i].trim().equalsIgnoreCase("top")){
                  suma1 = suma1 + 5;
              }
          }
        System.out.println("Vrednost figura prvog igraca je: " + suma1);



        int suma2 = 0;

        for (int i = 0; i <= n2-1 ; i++) {

        if (igrac2[i].trim().toUpperCase().charAt(1) == 'R') {
               suma2 = suma2 + 12;
                 }
        else if (igrac2[i].toLowerCase().contains("pe")){
              suma2 = suma2 + 1;
                 }
        else if (igrac2[i].toUpperCase().contains("KONJ") || igrac2[i].toUpperCase().contains("LOV")){
               suma2 = suma2 + 3;
                 }
        else if(igrac2[i].trim().equalsIgnoreCase("top")){
            suma2 = suma2 + 5;
                }
       }

        System.out.println("Vrednost figura drugog igraca je: " + suma2);

        if (suma1 > suma2){
                 System.out.println("Prvi igrač je u boljoj poziciji.");
            }
        else if (suma2 > suma1){
                 System.out.println("Drugi igrač je u boljoj poziciji.");
           }
        else {
            System.out.println("Prvi i drugi igrač su u istoj poziciji.");
          }
}








    }

