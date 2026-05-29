public class r9 {
    public static void main(String[] args) {
        int sonuc = faktoriyel(5);
        System.out.println("5 Faktöriyel: " + sonuc);
    }

    // Kendi kendini çağıran Recursive Metot
    public static int faktoriyel(int n) {

        // 1. ALTIN KURAL: Durma Koşulu (Fren)
        // Eğer sayı 1'e veya 0'a düştüyse daha fazla aşağı inme, 1 döndür.
        if (n <= 1) {
            return 1;
        }
        // 2. ALTIN KURAL: Kendi kendini çağırma
        // n sayısını al, metodun içine (n-1) koyarak METODU TEKRAR ÇALIŞTIR!
        else {
            return n * faktoriyel(n - 1);
        }
    }
}