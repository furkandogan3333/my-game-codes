//Klavyeden girilen 2 sayı arasındaki sayılardan 5 in katlarını ekrana yazdıran bir metot yazınız.

import java.util.Scanner;

public class r1 {
    public static void main(String[] args) {

        Scanner giris = new Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz: ");
        int sayi1 = giris.nextInt();

        System.out.print("ikinci sayıyı giriniz: ");
        int sayi2 = giris.nextInt();

        System.out.println("Aradaki 5'in katları:");
        besinkatlari(sayi1, sayi2);

    }

    // Madem burada sayi1 ve sayi2 dedik, içeride de bunları kullanmak zorundayız.
    public static void besinkatlari(int sayi1, int sayi2) {

        // s1 ve s2 yerine metodun tanıdığı sayi1 ve sayi2'yi kullanıyoruz.
        for(int i = sayi1 ; i < sayi2 ; i++){

            // Sabit olan sayi1'i değil, döngüde artan i sayısını 5'e bölüyoruz.
            if(i % 5 == 0) {
                System.out.println(i);
            }
        }

    }
}