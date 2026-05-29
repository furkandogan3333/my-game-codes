//Parametre olarak yollanan bir sayının asal sayı olup olmadığını geriye döndüren bir metot yazınız.
// Eğer sayı asal ise geriye “true” değil ise “false” değeri döndürülecektir.


import java.util.Scanner;

public class r6 {
    public static void main(String[] args){

        Scanner giris = new Scanner(System.in);
        System.out.print("Sayı giriniz: ");
        int sayi1 = giris.nextInt();

        // Metot artık geriye true/false (boolean) döndürüyor.
        // Dönen sonucu bir değişkende yakalayıp ekrana yazdırıyoruz.
        boolean sonuc = AsalMi(sayi1);
        System.out.println("Sayı asal mı?: " + sonuc);

        giris.close();
    }

    // void yerine boolean yazdık çünkü geriye true/false dönecek
    public static boolean AsalMi(int sayi1) {

        // 2'den küçükse asal değildir, direkt false döndür (continue değil)
        if (sayi1 < 2) {
            return false;
        }

        // Sayıyı en baştan "Asaldır" (true) olarak etiketliyoruz
        boolean asalDurumu = true;

        for (int bolen = 2; bolen < sayi1; bolen++) {

            if (sayi1 % bolen == 0) {
                asalDurumu = false; // Etiketi "asal değil" olarak değiştir
                break; // Başka sayılara bölmeye gerek kalmadı, döngüyü hemen bitir
            }
        }

        // Döngü bittikten sonra elimizde kalan son durumu main'e fırlatıyoruz
        return asalDurumu;
    }
}