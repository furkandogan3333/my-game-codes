//Kendisine yollanan 2 tam sayı ve hesaplama operatörüne göre dört işlemden istenileni yapıp sonucu geriye döndüren bir metot yazınız.


import java.util.Scanner;

public class r3 {
    public static void main(String[] args){

        Scanner giris = new Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz: ");
        int sayi1 = giris.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        int sayi2 = giris.nextInt();

        System.out.println("Toplama için 1, Çıkarma için 2, Çarpma için 3, Bölme için 4 yazınız:");
        int islem = giris.nextInt(); // İşlemi de main içinde alıyoruz

        // Metodu çağırıyoruz. Sayıları VE işlemi gönderiyoruz.
        // Metottan "return" ile dönen cevabı burada yakalayıp "gelenSonuc" değişkenine atıyoruz.
        double gelenSonuc = isleminsonucu(sayi1, sayi2, islem);

        System.out.println("İşlemin sonucu: " + gelenSonuc);

        giris.close();
    }

    // "void" kelimesini sildik, yerine geriye dönecek verinin tipini (double) yazdık.
    // Parametre olarak int islem'i de ekledik.
    public static double isleminsonucu(int sayi1, int sayi2, int islem) {

        double sonuc = 0; // Bölme ondalıklı olabileceği için double kullanıyoruz

        // Senin kurduğun güzel mantık aynen burada:
        if (islem == 1) sonuc = sayi1 + sayi2;
        if (islem == 2) sonuc = sayi1 - sayi2;
        if (islem == 3) sonuc = sayi1 * sayi2;
        if (islem == 4) {
            // Tam sayı bölmesi yapıp küsuratları silmesin diye sayilardan birini double'a çeviriyoruz
            sonuc = (double) sayi1 / sayi2;
        }

        // Metodun işi bittiğinde bulduğu sonucu kendisini çağıran yere geri fırlatıyor
        return sonuc;
    }
}