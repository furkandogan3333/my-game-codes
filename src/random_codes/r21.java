public class r21 {

    public static String[] satirlariBirlestir(String[][] dizi, int satir1, int satir2) {
        // Seçilen satırın kaç sütunu (elemanı) olduğunu buluyoruz
        int sutunSayisi = dizi[satir1].length;

        // İki satırdaki elemanları yan yana koyacağımız için 2 katı büyüklükte yeni dizi oluşturuyoruz
        String[] sonuc = new String[sutunSayisi * 2];

        // Yeni dizinin hangi indeksine yazacağımızı takip eden sayaç
        int index = 0;

        // Sütunları sırayla gezen döngü
        for (int i = 0; i < sutunSayisi; i++) {
            // Önce birinci satırın i. elemanını ekle
            sonuc[index] = dizi[satir1][i];
            index++; // Bir sonraki boş hücreye geç

            // Sonra ikinci satırın i. elemanını ekle
            sonuc[index] = dizi[satir2][i];
            index++; // Bir sonraki boş hücreye geç
        }

        // Oluşturduğumuz tek boyutlu diziyi geri döndürüyoruz
        return sonuc;
    }

    // Kodu test etmek için main metodu
    public static void main(String[] args) {
        // Sorudaki örnek tabloyu oluşturuyoruz
        String[][] tablo = {
                {"Elma", "Armut", "Muz", "Çilek"},
                {"Kalem", "Silgi", "Defter", "Kitap"},
                {"Masa", "Sandalye", "Dolap", "Halı"},
                {"Kedi", "Köpek", "Kuş", "Balık"}
        };

        // Metodu 0. ve 2. satırlar için çağırıyoruz
        String[] birlesmisDizi = satirlariBirlestir(tablo, 0, 2);

        // Sonucu ekrana yazdırıyoruz
        System.out.print("[");
        for (int i = 0; i < birlesmisDizi.length; i++) {
            System.out.print(birlesmisDizi[i]);
            if (i < birlesmisDizi.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}