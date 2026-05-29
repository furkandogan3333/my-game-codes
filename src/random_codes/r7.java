//Parametre olarak yollanan bir cümleyi tersten ekrana yazdıran bir metot yazınız.

import java.util.Scanner;

public class r7 {
    public static void main(String[] args) {

        Scanner giris = new Scanner(System.in);

        System.out.print("Tersten yazdırmak için bir cümle giriniz: ");
        // Sadece bir kelime değil, tüm cümleyi (boşluklarıyla) almak için next() yerine nextLine() kullanıyoruz.
        String cumle = giris.nextLine();

        System.out.print("Cümlenin tersten yazılışı: ");
        // Aldığımız cümleyi metodumuza fırlatıyoruz
        terstenYazdir(cumle);

        giris.close();
    }

    // Metodumuz dışarıdan bir String (metin) bekliyor, ekrana yazdıracağı için void kullanıyoruz
    public static void terstenYazdir(String metin) {

        // Döngüyü kelimenin en son harfinden başlatıyoruz.
        // İndeksler 0'dan başladığı için son harfin indeksi her zaman (uzunluk - 1) olur.
        for (int i = metin.length() - 1; i >= 0; i--) {

            // i. sıradaki harfi al ve yan yana (print ile) ekrana yaz
            System.out.print(metin.charAt(i));
        }

        System.out.println(); // İşlem bitince alt satıra geçmek için boş bir print
    }
}