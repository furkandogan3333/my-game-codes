package dungeongame;//zindan oyunu demo 1.0                // Dungeon Game Demo 1.0
//karakterin 10 canı var               // Player has 10 HP (Health Points)
//karakterin 1d6 saldırı gücü var      // Player has 1d6 attack power
//1d4 kalkanı var                      // Player has 1d4 shield
//kalkan her tur sıfırlanır            // Shield resets every turn


import java.util.Random;
import java.util.Scanner;
public class dungeongame1 {
    public static void main(String[] args) {

        Scanner giris=new Scanner(System.in);
        Random rnd = new Random();

        int mc=0,HP=10,event;
        int gobHP=10;

        System.out.println("zindana hoşgeldin");                 // Only one character available in this version
        System.out.println("hangi karakteri seçmek istiyorsun"); // tek karakter var bu sürümde
        mc =giris.nextInt();

        System.out.println("zindan girişinde 2 adet kapı görüyorsun.");
        System.out.println("1.kapıda savaş olacağını hissediyorsun 2. kapıda sandık görüyorsun");
        System.out.println("gideceğin kapının numarasını klavyeden yaz");
        event =giris.nextInt();

        if (event==2){
            System.out.println("kapıyı açıyorsun... sandığa doğru yürümeye başlıyorsun");
            System.out.println("karakterin bir acemi olduğu için sandıktaki tuzağı fark etmiyor");
            System.out.println("sandık seni yutuyor ve ölüyorsun");
        }

        if (event==1){
            System.out.println("kapıyı açıyorsun... karşında bir tane goblin var ve üzerine doğru koşmaya başlıyor");
            System.out.println("insiyatif sende ama tek yapabileceğin şey kılıçla saldırmak :d");
            System.out.println("kılıcını aldın ve gobline doğru savurdun");

            do{
                System.out.println("saldırıya devam etmek için klavyeye 1 yaz");
                event =giris.nextInt();
                if (event==1){
                    int McAttack = rnd.nextInt(1,7);

                    System.out.println("goblin " + McAttack + " hasar yedi");
                    gobHP-=McAttack;
                    System.out.println("goblinin " + gobHP + " canı kaldı");
                    if (gobHP<0) break;

                    int GobAttack = rnd.nextInt(1,9);
                    System.out.println("goblinin saldırı gücü:"+GobAttack);

                    int kalkan = rnd.nextInt(1,5);
                    System.out.println("bu tur kalkanın:"+kalkan);

                    if (GobAttack > kalkan){
                        GobAttack -= kalkan;
                        HP -= GobAttack;
                        System.out.println("kalan canın: "+HP);
                        if (HP<0){
                            System.out.println("öldün");
                            System.exit(0);
                        }

                    }
                    if (GobAttack < kalkan) {
                        System.out.println("şanslısın kalkanın tamamen saldırıyı blockladı");
                    }
                    kalkan = 0;

                }


            }while(gobHP>0);
            System.out.println("goblin öldü");

        }
        System.out.println("demo btti :d");




    }
}