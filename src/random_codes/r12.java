
import java.util.Scanner;
public class r12 {
    public static void main(String[] args) {

        Scanner giris = new Scanner(System.in);

        String kelime, harf, kucukkelime,buyukharf,degismis;

        System.out.println("bir kelime giriniz:");
        kelime = giris.nextLine();

        System.out.println("bir harf giriniz:");
        harf = giris.nextLine();

        kucukkelime = kelime.toLowerCase();
        buyukharf = harf.toUpperCase();
        degismis = kucukkelime.replace(harf,buyukharf);

        System.out.println("kelimenin son hali:"+degismis);


    }
}