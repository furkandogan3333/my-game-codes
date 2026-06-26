

import java.util.Scanner;

public class r19 {
    public static void main(String[] args) {

        Scanner oku = new Scanner(System.in);
        String  kelime1,kelime2;
        char harf1,harf2,harfk1,harfk2;

        System.out.println("arasında boşluk olacak şekiklde iki kelimeli bir cümle gir");
        String str1 = oku.nextLine();

        String[] dizi = str1.split(" ");
        kelime1 = dizi[0];
        kelime2 = dizi[1];

        kelime1 = kelime1.toUpperCase();
        kelime2 = kelime2.toUpperCase();

        harf1 = kelime1.charAt(0);
        harf2 = kelime2.charAt(0);

        kelime1 = kelime1.toLowerCase();
        kelime2 = kelime2.toLowerCase();
        harfk1 = kelime1.charAt(0);
        harfk2 = kelime2.charAt(0);

        kelime1 = kelime1.replaceFirst(harfk1,harf1 );
        kelime2 = kelime2.replaceFirst(harfk2,harf2 );
        System.out.println(kelime2 + " "+kelime1);


    }

}
