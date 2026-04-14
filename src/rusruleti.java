//rus ruleti


import java.util.Random;
import java.util.Scanner;
public class rusruleti {
    public static void main(String[] args) {

        Scanner giris=new Scanner(System.in);
        Random rnd = new Random();

        int ilksecim,karar = 1,kumar,a,b=7;
        double kazanilanpara=0;

        System.out.println("kaç dolar yatırmak istiyorsun?");
        kumar =giris.nextInt();

        do {
            for (a=1;a<b;a++){
                System.out.println(a +".mermi");
            }

            int dolumermi = rnd.nextInt(1,b);

            System.out.println("yukarıdaki mermilerden birinin saysını yaz");
            ilksecim =giris.nextInt();

            if (ilksecim == dolumermi){
                System.out.println("Kaybettin");
                karar = 0;
            }
            else {
                if (b==7) kazanilanpara = kumar * 1.25;
                if (b==6) kazanilanpara = kumar * 1.5;
                if (b==5) kazanilanpara = kumar * 2;
                if (b==4) kazanilanpara = kumar * 4;
                if (b==3) kazanilanpara = kumar * 8;
                if (b==2) kazanilanpara = kumar * 16;
                System.out.println(kazanilanpara);
                System.out.println("kazandınınz devam etmek istermisiniz? devam etmek isterseniz 1 istemezseniz 0 giriniz");
                karar =giris.nextInt();
                b--;
            }

        }while (karar == 1);
    }
}