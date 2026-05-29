// Örnek: usAl(2, 3) çağrıldığında metot 2 * 2 * 2 işlemini yapıp 8 döndürmelidir.
// Örnek: usAl(5, 2) çağrıldığında 5 * 5 işlemini yapıp 25 döndürmelidir.

import java.util.Scanner;

public class r11 {
    public static void main(String[] args) {

        Scanner giris = new Scanner(System.in);

        System.out.print("Taban sayısını giriniz: ");
        int taban = giris.nextInt();

        System.out.print("Üs sayısını giriniz: ");
        int us = giris.nextInt();

        int sonuc = usAl(taban, us);
        System.out.println("Sonuç: " + sonuc);

        giris.close();
    }

    public static int usAl(int taban, int us) {

        // 1. DURMA KOŞULU (FREN)
        // Eğer üs 0'a ulaştıysa geriye 1 döndür (Her sayının 0. kuvveti 1'dir)
        if (us == 0) {
            return 1;
        }
        // 2. KENDİ KENDİNİ ÇAĞIRMA (RECURSIVE ADIM)
        // Tabanı, üssü bir küçültülmüş metotla çarp ve tekrar et!
        else {
            return taban * usAl(taban, us - 1);
        }
    }
}