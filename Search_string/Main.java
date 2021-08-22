import java.util.Scanner;

public class Main extends Thread {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String a = in.next();
        System.out.print("\n" + "Ведите первую подстроку: ");
        String b = in.next();
        System.out.print("\n" + "Введите вторую подстроку: ");
        String c = in.next();
        Search s1 = new Search(a, b);
        Search s2 = new Search(a, c);
        s1.start();
        s2.start();
    }
}
