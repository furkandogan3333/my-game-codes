public class r18 {
    public static void main(String[] args) {
        String str1 = "Bugün hava çok ama çok güzel";
        int bulunanIndex = str1.indexOf("çok");
        System.out.println(bulunanIndex);

        bulunanIndex = str1.indexOf("çok", 20);
        System.out.println(bulunanIndex);

    }
}