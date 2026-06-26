import java.util.Scanner;

public class r14 {
    public static void main(String[] args) {

        Scanner giris = new Scanner(System.in);

        System.out.print("3 basamakli sayi giriniz: ");
        int sayi = giris.nextInt();

        Boolean sonuc = armstrongSayiMi(sayi);

        System.out.println("armstrong sayi mi:" + sonuc);
    }

    public static boolean armstrongSayiMi(int sayi) {
        // Sayının basamaklarını ayırma işlemleri
        int yuzler = sayi / 100;           // Örn: 371 / 100 = 3
        int onlar = (sayi / 10) % 10;      // Örn: (371 / 10) = 37 -> 37 % 10 = 7
        int birler = sayi % 10;            // Örn: 371 % 10 = 1

        // Basamakların küplerinin toplamını hesaplama
        int kupToplam = (yuzler * yuzler * yuzler) +
                (onlar * onlar * onlar) +
                (birler * birler * birler);

        // Toplam, orjinal sayıya eşitse true, değilse false döner
        return kupToplam == sayi;
    }
}
