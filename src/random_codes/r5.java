//50 elemanlı bir diziye 0-100 arasında rastgele sayılar atanacaktır.
//DiziyiSirala adında bir metot a diziparametre olarak yollanacaktır.
//Metot diziyi küçükten büyüğe doğru sıralayarak ekrana yazdıracaktır.


import java.util.Random;
import java.util.Arrays; // Diziyi sıralamak için gerekli kütüphane

public class r5 {
    public static void main(String[] args) {

        // 50 elemanlı boş bir tam sayı dizisi oluşturuyoruz
        int[] sayilar = new int[50];

        // Rastgele sayı üretebilmek için Random nesnesi oluşturuyoruz
        Random rastgele = new Random();

        // Döngü yardımıyla dizinin tüm odalarını tek tek gezip rastgele sayı atıyoruz
        for (int i = 0; i < sayilar.length; i++) {
            // nextInt(101) komutu 0 ile 100 (dahil) arasında rastgele sayı üretir
            sayilar[i] = rastgele.nextInt(101);
        }

        System.out.println("Dizi rastgele sayılarla dolduruldu ve metoda gönderiliyor...\n");

        // İçini doldurduğumuz "sayilar" dizisini alıp metodumuza fırlatıyoruz
        DiziyiSirala(sayilar);
    }

    // Metodumuz dışarıdan bir "tam sayı dizisi" bekliyor
    public static void DiziyiSirala(int[] dizi) {

        // Java'nın kendi alet çantasındaki sort() metodu ile diziyi küçükten büyüğe sıralıyoruz
        Arrays.sort(dizi);

        // Sıralanmış diziyi ekrana yazdırmak için döngü kuruyoruz
        System.out.println("Küçükten Büyüğe Sıralanmış Hali:");
        for (int i = 0; i < dizi.length; i++) {
            // println yerine print kullanıyoruz ki sayılar yan yana yazılsın
            // (Araya tire veya boşluk koyarak daha okunaklı yapıyoruz)
            System.out.print(dizi[i] + " - ");
        }
    }
}