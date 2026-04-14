//taş kağıt makas oyunu

import java.util.Scanner;
import java.util.Random;

public class taskagitmakas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] secenekler = {"Taş", "Kağıt", "Makas"};

        System.out.println("Taş-Kağıt-Makas Oyununa Hoş Geldiniz");
        System.out.println("Seçiminizi yapın: (0: Taş, 1: Kağıt, 2: Makas)");

        int kullaniciSecimi = scanner.nextInt();

        if (kullaniciSecimi < 0 || kullaniciSecimi > 2) {
            System.out.println("Lütfen sadece 0, 1 veya 2 rakamlarını kullanın.");
        } else {

            int bilgisayarSecimi = random.nextInt(3);

            System.out.println("Sizin seçiminiz: " + secenekler[kullaniciSecimi]);
            System.out.println("Bilgisayarın seçimi: " + secenekler[bilgisayarSecimi]);


            if (kullaniciSecimi == bilgisayarSecimi) {
                System.out.println("Berabere");

            } else if ((kullaniciSecimi == 0 && bilgisayarSecimi == 2) ||
                    (kullaniciSecimi == 1 && bilgisayarSecimi == 0) ||
                    (kullaniciSecimi == 2 && bilgisayarSecimi == 1)) {
                System.out.println("Tebrikler, kazandınız");
            } else {
                System.out.println("Bilgisayar kazandı");
            }
        }


    }
}