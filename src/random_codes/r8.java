//rastgeleSayiUret(int baslangicDegeri, int bitisDegeri, int adet) metodu kendisine parametre olarak yollanan
//başlangıç değeri ile bitiş değeri arasında istenilen adet kadar rastgele sayı tutup ekrana yazdıracaktır.

import java.util.Scanner;
import java.util.Random;

public class r8 {
    public static void main(String[] args){

        int baslangicDegeri,bitisDegeri,adet;

        Scanner giris = new Scanner(System.in);

        System.out.println("başlangış değeri giriniz");
        baslangicDegeri = giris.nextInt();

        System.out.println("bitiş değeri giriniz");
        bitisDegeri = giris.nextInt();

        System.out.println("adet sayısı giriniz");
        adet = giris.nextInt();


        tutulansayilar(baslangicDegeri,bitisDegeri,adet);
    }
    public static void tutulansayilar(int baslangicDegeri,int bitisDegeri,int adet){

        Random rnd = new Random();
        int tutulansayi;
        for (int i = 0;i<adet;i++){
            tutulansayi = rnd.nextInt(bitisDegeri - baslangicDegeri +1) + baslangicDegeri;
            System.out.println("tutulan sayi:" + tutulansayi);
        }


    }
}