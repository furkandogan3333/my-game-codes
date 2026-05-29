//kendisine yollanan iki pozitif tam sayı arasındaki tam sayıların toplamını bulan bir recursive metod yazınız.
//örnek sayilariTopla(5,20) metodu çağrıldığında 5+6+....19+20 işlemin sonucunu döndürecektir
// birinci sayının ikinci sayıdan her zaman kçük olduğunu varsay

import java.util.Scanner;

public class r10 {
    public static void main(String[] args){
        int sayi1, sayi2;
        Scanner giris = new Scanner(System.in);

        System.out.print("Başlangıç değeri giriniz: ");
        sayi1 = giris.nextInt();

        System.out.print("Bitiş değeri giriniz: ");
        sayi2 = giris.nextInt();

        int toplam = sayilariTopla(sayi1, sayi2);
        System.out.println("Sayıların toplamı: " + toplam);

        giris.close();
    }

    public static int sayilariTopla(int sayi1, int sayi2) {

        // 1. ALTIN KURAL: Durma Koşulu (Fren)
        // Eğer sayi1, sayi2'ye eşitlendiyse (örneğin 20 == 20) artık toplayacak bir şey kalmamıştır.
        // O sayıyı döndür ve recursive zincirini bitir.
        if (sayi1 == sayi2) {
            return sayi1;
        }
        // 2. ALTIN KURAL: Kendi Kendini Çağırma (Recursive Call)
        // O anki sayi1'i al, ve metodun içine sayi1'in bir fazlasını göndererek TEKRAR ÇALIŞTIR.
        else {
            return sayi1 + sayilariTopla(sayi1 + 1, sayi2);
        }
    }
}