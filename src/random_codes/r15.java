public class r15 {
    public static void main(String[] args) {
        int[] sayilar = {2,3,5,6,9};
        elemanToplami(sayilar);//gelenDizi = sayilar;
    }
    //kendisine yollanan sayısal dizinin
    //elemanlarının toplamını bulup
    //ekrana yazdıran metot
    public static void elemanToplami(int[] gelenDizi){
        int toplam = 0;
        for (int siradakiEleman : gelenDizi) {
            toplam+=siradakiEleman;
        }
        System.out.println(toplam);
    }

}