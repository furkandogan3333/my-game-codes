package dungeongame;//zindan oyunu demo 1.1                // Dungeon Game Demo 1.1
//xp sistemi getirildi                 // Added XP system
//yeni odalar eklendi                  // Added new rooms


import java.util.Random;
import java.util.Scanner;
public class dungeongame2 {
    public static void main(String[] args) {

        Scanner giris=new Scanner(System.in);
        Random rnd = new Random();

        int mc=0,HP=10,xp=0,event,jump=0,jump2=0,jump3=0;
        int gobHP=10,gob1HP=10,gob2HP=10;
        System.out.println("zindana hoşgeldin");                 // Only one character available in this version
        System.out.println("hangi karakteri seçmek istiyorsun"); // tek karakter var bu sürümde
        mc =giris.nextInt();

        System.out.println("zindan girişinde 2 adet kapı görüyorsun.");
        System.out.println("Önündeki kapılardan birincisi yaklaşan bir savaşın gürültüsünü fısıldarken, ikincisi loş ışıkta parıldayan bir sandığı ele veriyor.");
        System.out.println("gideceğin kapının numarasını klavyeden yaz");
        event =giris.nextInt();

        if (event==2){
            System.out.println("kapıyı açıyorsun... sandığa doğru yürümeye başlıyorsun");
            System.out.println("sandığı açıyorsun ve içinden mızrak çıkıyor artık hasarın 1d8");

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
                    System.out.println("bu tur kalkanın:"+ kalkan);

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
            System.out.println("goblini öldürdüğün içi 1 xp kazandın 2 xp olunca level atlıyacaksın");
            System.out.println("goblinin mızrağını alıyorsun artık hasarın 1d8");
            xp+=1;
        }
        HP=10;

        System.out.println("Önünde iki yol ayrılıyor: İlk odada aşılması güç bir parkur uzanırken, diğer odada bir sandığın başında fısıldaşan iki goblin göze çarpıyor.");
        System.out.println("gideceğin kapının numarasını klavyeden yaz");
        event =giris.nextInt();
        if (event==1){

            System.out.println("Karşında küçükten büyüğe titizlikle sıralanmış üç sütun yükseliyor. ");
            System.out.println("Yolun devamı, bu dizilimin sonundaki en yüksek sütunun hizasında seni bekliyor.");
            System.out.println("her sütuna zıplayışında 1d6 zar atacaksın, zarların 4 ve üstü olmalı");
            do {
                System.out.println("parkura devam etmek için klavyeye 1 yaz");
                event =giris.nextInt();
                if (event==1){
                    System.out.println("ilk sütuna yaklaşıyorsun ve tüm gücünle zıplıyorsun");
                    jump = rnd.nextInt(1,7);
                    if (jump < 4){
                        System.out.println("sütuna zıplıyorsun ama dengede duramadığın için düşüyorsun");

                        if (HP<1){
                            System.out.println("öldün");
                            break;
                        }
                        System.out.println("tekrar başa dönüyorsun");

                    }
                    if (jump > 3){
                        System.out.println("güzel zıplayış en azından bu kadarını yapabiliyorsun");
                        System.out.println("parkura devam etmek için klavyeye 1 yaz");
                        event =giris.nextInt();

                        if (event==1){
                            System.out.println("biraz odaklandıktan sonra 2. sütuna doğru zıplıyorsun");
                            jump2 = rnd.nextInt(1,7);
                            if (jump2 < 4){
                                System.out.println("sütunad doğru zıplarken ayağın kayıyor ve yüz üstü düşüyorsun");
                                HP-=1;
                                System.out.println("canın 1 HP azaldı, kalan canın:"+HP);
                                if (HP<1){
                                    System.out.println("öldün");
                                    break;
                                }
                                System.out.println("tekrar başa dönüyorsun");
                            }
                            if (jump2 > 3){
                                System.out.println("bir şekilde sütunu üst kısmı tutabiliyorsun ve kenidini yukarı doğru çekiyorsun");
                                System.out.println("şanslı gibisin, çekirge 1 zıplar 2 zıplar üçüncüyü zıplayabilecekmisin bakalım");
                                System.out.println("parkura devam etmek için klavyeye 1 yaz");
                                event =giris.nextInt();

                                if (event==1){

                                    System.out.println("özgüvenini toplayıp son sütuna doğru zıplıyorsun");
                                    jump3 = rnd.nextInt(1,7);

                                    if (jump3 < 4){
                                        System.out.println("ne yazık ki kötü bir zıplayış yapıyorsun");
                                        HP-=2;
                                        System.out.println("canın 2 HP azaldı, kalan canın:"+HP);
                                        if (HP<1){
                                            System.out.println("öldün");
                                            break;
                                        }
                                        System.out.println("tekrar başa dönüyorsun");
                                    }

                                    if (jump3 > 3){

                                        System.out.println("sütunun üst kısmını yakalayamayınca düşeceğini sanıyorsun ama şansa kırık bir kısma tutunuyorsun");
                                        System.out.println("kendini yukarıya çekerek bir şekilde hayatta kalıyorsun");
                                        System.out.println("bu deneyim için 1 xp kazanıyorsun");
                                        xp+=1;

                                        if (xp==2){
                                            System.out.println("level atladın artık canın 15");
                                            HP=15;
                                        }

                                        System.out.println("yola devam edeceğin için mutluluk duyarken yan tarafında bir ceset görüyorsun");
                                        System.out.println("ceseti inceliyorsun, cesetten bir eldiven buluyorsun");
                                        System.out.println("eldiven kalkanına 1d2 kalkan ekliyor");

                                    }
                                }

                            }
                        }


                    }
                }

            }while (jump3<4);
            System.out.println("yola devam");

        }
        if (event==2){



            System.out.println("Odaya girdiğinde iki goblini bir sandığın başında fısıldaşırken buluyorsun.");
            System.out.println(" Seni fark eder etmez silahlarına davranıyorlar!");
            System.out.println(" kılıçlı olan sana doğru koşarken diğeri yayını çekmeye başlıyor");

            do {
                System.out.println("saldırıya devam etmek için klavyeye 1 yaz");
                event =giris.nextInt();

                if (event==1){

                    if (gob1HP>0){
                        int McAttack = rnd.nextInt(1,9);
                        System.out.println("kılıçlı goblin " + McAttack + " hasar yedi");
                        gob1HP-=McAttack;
                        System.out.println("kılıçlı goblinin " + gob1HP + " canı kaldı");

                        if (gob1HP>0){

                            int Gob1Attack = rnd.nextInt(1,9);
                            System.out.println("goblinin saldırı gücü:"+Gob1Attack);

                            int kalkan = rnd.nextInt(1,5);
                            System.out.println("bu tur kalkanın:"+kalkan);

                            if (Gob1Attack > kalkan){
                                Gob1Attack -= kalkan;
                                HP -= Gob1Attack;
                                System.out.println("kalan canın: "+HP);
                                if (HP<0){
                                    System.out.println("öldün");
                                    System.exit(0);
                                }

                            }
                            if (Gob1Attack < kalkan) {
                                System.out.println("şanslısın kalkanın tamamen saldırıyı blockladı");
                            }

                        }
                        if (gob1HP<1){
                            System.out.println("kılıçlı goblin öldü sırada okçu goblin var");
                        }


                    }
                    if (gob2HP>0){

                        int Gob2Attack = rnd.nextInt(1,5);
                        System.out.println("okçu goblinin saldırı gücü:"+Gob2Attack);

                        int kalkan = rnd.nextInt(1,5);
                        System.out.println("bu tur kalkanın:"+kalkan);

                        if (Gob2Attack > kalkan){
                            Gob2Attack -= kalkan;
                            HP -= Gob2Attack;
                            System.out.println("kalan canın: "+HP);
                            if (HP<0){
                                System.out.println("öldün");
                                System.exit(0);
                            }

                        }
                        if (Gob2Attack <= kalkan) {
                            System.out.println("şanslısın kalkanın tamamen saldırıyı blockladı");
                        }


                        if (gob1HP < 0){

                            int McAttack = rnd.nextInt(1,9);
                            System.out.println("okçu goblin " + McAttack + " hasar yedi");
                            gob2HP-=McAttack;
                            System.out.println("okçu goblinin " + gob2HP + " canı kaldı");

                        }

                        if (gob2HP <= 0){

                            System.out.println("okçu goblin öldü");
                            System.out.println("bu çekişmeli dövüş için 1 xp kazanıyorsun");
                            xp+=1;

                            if (xp==2){
                                System.out.println("level atladın artık canın 15");
                                HP=15;
                            }

                        }

                    }



                }

            }while(gob1HP > 0 || gob2HP > 0);

            System.out.println("demo 1.1 bitti");

        }


    }
}