//Çağrıldığında klavyeden 10 tane tam sayı girişi yapılıp bu sayılardan en büyük olanını geriye döndüren bir metot yazınız.

import java.util.Scanner;

public class r4 {
    public static void main(String[] args) {

        System.out.println("10 sayı gireceksiniz. Program en büyüğünü seçecek.");

        // Metodu çağırıyoruz (içine bir şey göndermiyoruz çünkü kendisi isteyecek)
        // Metodun return ile fırlattığı değeri "gelenEnBuyuk" değişkeninde yakalıyoruz
        int gelenEnBuyuk = enBuyuguBul();

        System.out.println("Girdiğiniz sayılar arasındaki EN BÜYÜK sayı: " + gelenEnBuyuk);

    }

    // Dışarıdan sayı beklemiyor (parantez içi boş), geriye int döndürüyor
    public static int enBuyuguBul() {

        Scanner giris = new Scanner(System.in);

        // 1. adımı döngü dışında yapıyoruz ki ilk sayıyı doğrudan tahta oturtalım
        System.out.print("1. sayıyı giriniz: ");
        int enBuyuk = giris.nextInt();

        // Geriye 9 sayı kaldı, o yüzden döngüyü 2'den başlatıp 10'a kadar götürüyoruz
        for (int i = 2; i <= 10; i++) {

            System.out.print(i + ". sayıyı giriniz: ");
            int yeniSayi = giris.nextInt();

            // Eğer yeni girilen sayı, bizim elimizdeki en büyükten daha büyükse...
            if (yeniSayi > enBuyuk) {
                enBuyuk = yeniSayi; // Taht el değiştiriyor! Artık yeni en büyük bu sayı.
            }
        }

        // Döngü bitti, 10 sayı da denendi. Elimizi kalan en büyük sayıyı main'e yolluyoruz.
        return enBuyuk;
    }
}