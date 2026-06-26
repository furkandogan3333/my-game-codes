import java.util.Scanner;

public class r13 {
    public static void main(String[] args) {
        double ilkAyKm,kacAy,alininaraba = 0,velininaraba=0;
        Scanner giris =new Scanner(System.in);

        System.out.println("ilk ay kaç km gidilecek?");
        ilkAyKm = giris.nextDouble();
        System.out.println("kaç ay gidilecek?");
        kacAy = giris.nextDouble();

        for (int i=0;i<kacAy;i++){

            alininaraba = alininaraba + (ilkAyKm/100)*(8);
            if (i%2 == 0) velininaraba = velininaraba + (ilkAyKm/100)*(7.5);
            else velininaraba = velininaraba + (ilkAyKm/100)*(8.5);

            System.out.println("Alinin toplam harcadığı yakıt=" + alininaraba);
            System.out.println("Velinin toplam harcadığı yakıt=" + velininaraba);

            ilkAyKm = ilkAyKm*(1.5);

        }


    }
}