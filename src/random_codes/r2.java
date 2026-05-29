//Kendisine yollanan 2 sayı arasındaki asal sayıları listeleyen ve ekrana yazdıran bir metot yazınız.

import java.util.Scanner;

public class r2 {
    public static void main(String[] args) {

        Scanner giris = new Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz: ");
        int sayi1 = giris.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        int sayi2 = giris.nextInt();

        System.out.println(sayi1 + " ile " + sayi2 + " arasındaki asal sayılar:");
        // Metodumuzu çağırıp sayıları yolluyoruz
        asalSayilariBul(sayi1, sayi2);

        giris.close();
    }

    // Dışarıdan iki sayı bekleyen metodumuz
    public static void asalSayilariBul(int sayi1, int sayi2) {

        // sayi1'den başlayıp sayi2'ye kadar dönen ana döngü
        for (int i = sayi1; i < sayi2; i++) {

            // Asal sayılar 2'den başlar, 2'den küçükse hiç kontrol etmeye gerek yok
            if (i < 2) {
                continue; // Bu sayıyı atla, döngünün başına dön ve bir sonraki sayıya geç
            }

            // Sayıyı baştan "asal" kabul ediyoruz
            boolean asalMi = true;

            // İç döngü: Sayıyı 2'den başlatıp kendisine kadar olan sayılara bölmeye çalışıyoruz
            for (int bölen = 2; bölen < i; bölen++) {

                // Eğer sayımız içerideki bölenlerden birine tam bölünürse...
                if (i % bölen == 0) {
                    asalMi = false; // Demek ki asal değilmiş!
                    break; // Asal olmadığını anladık, diğer sayılara bölmeye çalışıp vakit kaybetmeye gerek yok, iç döngüyü kır.
                }
            }

            // İç döngü bittiğinde asalMi hala "true" kalabildiyse, sayımız gerçekten asaldır.
            if (asalMi == true) {
                System.out.println(i);
            }
        }
    }
}