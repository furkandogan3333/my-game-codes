import java.util.Scanner;
import java.util.Random;

public class Odev1 {
    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);

        String[] kelimeler = {
                "besiktas", "programlama", "algoritma", "bilgisayar",
                "klavye", "kodlama", "yazilim", "internet",
                "universite", "laptop"
        };

        String[] sKelimeler = new String[5];

        for (int i = 0; i < 5; i++) {
            String secilenKelime = kelimeSec(kelimeler, sKelimeler, i);
            sKelimeler[i] = secilenKelime;

            oyunuBaslat(secilenKelime, giris);

            if (i < 4) {
                System.out.print("Tekrar oynamak istiyor musunuz? (e/h): ");
                char cevap = giris.next().toLowerCase().charAt(0);

                if (cevap != 'e') {
                    break;
                }
            } else {
                System.out.println("Maksimum 5 oyun hakkınız doldu.");
            }
        }
    }

    public static String kelimeSec(String[] havuz, String[] kullanilanlar, int adet) {
        Random rnd = new Random();
        String secim;
        boolean dahaOnceSecildi;

        do {
            dahaOnceSecildi = false;
            secim = havuz[rnd.nextInt(havuz.length)];

            for (int i = 0; i < adet; i++) {
                if (secim.equals(kullanilanlar[i])) {
                    dahaOnceSecildi = true;
                }
            }
        } while (dahaOnceSecildi);

        return secim;
    }

    public static void oyunuBaslat(String kelime, Scanner giris) {
        int uzunluk = kelime.length();
        char[] ekran = new char[uzunluk];
        int hak = 15;
        boolean bildiMi = false;

        System.out.println("Kelime " + uzunluk + " karakterlidir.");

        for (int i = 0; i < uzunluk; i++) {
            ekran[i] = '*';
        }

        ekran[0] = Character.toUpperCase(kelime.charAt(0));
        if (uzunluk >= 8) {
            ekran[uzunluk - 1] = Character.toUpperCase(kelime.charAt(uzunluk - 1));
        }

        while (hak > 0 && !bildiMi) {
            System.out.println("\nKelime: " + new String(ekran));
            System.out.println("Kalan Hak: " + hak);
            System.out.print("Bir harf giriniz: ");
            char girilenHarf = giris.next().toLowerCase().charAt(0);

            boolean varMi = false;
            for (int i = 0; i < kelime.length(); i++) {
                if (kelime.charAt(i) == girilenHarf) {
                    ekran[i] = Character.toUpperCase(girilenHarf);
                    varMi = true;
                }
            }

            if (!varMi) {
                System.out.println("Harf yok");
            }

            hak--;

            bildiMi = true;
            for (int i = 0; i < ekran.length; i++) {
                if (ekran[i] == '*') {
                    bildiMi = false;
                    break;
                }
            }
        }

        if (bildiMi) {
            System.out.println("Kelime: " + kelime.toUpperCase());
            System.out.println("Tebrikler");
        } else {
            System.out.println("Bilemediniz");
        }
    }
}