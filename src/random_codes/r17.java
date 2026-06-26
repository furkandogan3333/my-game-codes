public class r17 {
    public static void main(String[] args) {
        String str = new String("SDUCeng");
        System.out.println(str);
        System.out.println(str.substring(3));
        System.out.println(str.substring(0, 3));
        System.out.println("----------");
        System.out.println(str);
        String s1=str.substring(0, 3);
        System.out.println(s1);

        s1=str.substring(3);
        System.out.println(s1);
    }
}