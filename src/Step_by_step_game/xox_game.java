package Step_by_step_game;

//Diziler ve metotlar çalışması    //array-and-methods-study
//coklu-metot-denemesi             //multi-method-practice

import java.util.Scanner;

public class xox_game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] tahta = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        char oyuncu = 'X';
        boolean oyunBitti = false;

        while (!oyunBitti) {
            tahtayiYazdir(tahta);
            System.out.println("Oyuncu " + oyuncu + ", sıra sende. Satır ve Sütun gir (0, 1, 2): ");
            int satir = scanner.nextInt();
            int sutun = scanner.nextInt();

            if (tahta[satir][sutun] == '-') {
                tahta[satir][sutun] = oyuncu;
                oyunBitti = kazananVarMi(tahta, oyuncu);

                if (oyunBitti) {
                    tahtayiYazdir(tahta);
                    System.out.println("Tebrikler! Oyuncu " + oyuncu + " kazandı!");
                } else {

                    oyuncu = (oyuncu == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Bu hücre zaten dolu! Tekrar dene.");
            }
        }
    }


    //bizim görmemiz için method
    public static void tahtayiYazdir(char[][] tahta) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tahta[i][j] + " ");  //print olduğu için yan yana yazar
            }
            System.out.println();                     //println alt satıra geçmek için
        }
    }

    // Diziyi tarayarak kazananı kontrol eden metod
    public static boolean kazananVarMi(char[][] tahta, char oyuncu) {
        //Yatay ve dikey kontrol
        for (int i = 0; i < 3; i++) {
            if ((tahta[i][0] == oyuncu && tahta[i][1] == oyuncu && tahta[i][2] == oyuncu) ||
                    (tahta[0][i] == oyuncu && tahta[1][i] == oyuncu && tahta[2][i] == oyuncu)) {
                return true;
            }
        }
        // Çapraz kontrol
        if ((tahta[0][0] == oyuncu && tahta[1][1] == oyuncu && tahta[2][2] == oyuncu) ||
                (tahta[0][2] == oyuncu && tahta[1][1] == oyuncu && tahta[2][0] == oyuncu)) {
            return true;
        }
        return false;
    }
}