import java.util.Scanner;

public class RedniDanUGodini {
    public static void main(String[] args) {

        int [] niz = {31,29,31,30,31,30,31,31,30,31,30,31};

        Scanner sc = new Scanner(System.in);
        System.out.print("Upišite dan: ");
        int dan = sc.nextInt();
        System.out.print("Upišite mesec: ");
        int mesec = sc.nextInt();
        System.out.print("Upišite godinu: ");
        int godina = sc.nextInt();


        if (godina % 4 != 0 || (godina % 4 == 0 && godina % 100 == 0 && godina % 400 != 0)) {
                niz[1] = 28;}
        System.out.println("Broj dana po mesecima za izabranu godinu:");
        for (int i = 0; i <=11 ; i++) {
            System.out.print(niz[i] + " ");}
        /* Ovaj deo se ne navodi u tekstu zadatka, ali sam stavila radi provere da li ispravno računa
        dane u februaru za različite godine. */


        int zbir = 0;

        if (mesec == 1){
            zbir =0;}
        else {for (int j = 0; j <= mesec-2 ; j++) {
            zbir = zbir + niz[j];}}

        int redniDan = dan + zbir;
        System.out.println("\nRedni dan: " + redniDan);



    }
}
