package Class;
import java.util.Scanner;

public class Search_class {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        A num0 = new A();
        num0.a = 6;
        A num1 = new A();
        num1.a = 7;
        A num2 = new A();
        num2.a = 33;
        A num3 = new A();
        num3.a = 72;
        A num4 = new A();
        num4.a = 26;
        A num5 = new A();
        num5.a = 3;

        num0.prev = null;
        num1.prev = num0;
        num2.prev = num1;
        num3.prev = num2;
        num4.prev = num3;
        num5.prev = num4;

        A top = num5;

        while (top != null) {
            System.out.print(top.a + " ");
            top = top.prev;
        }
        System.out.println();
        System.out.println("Введите значение, которое требуется найти: ");
        int k = in.nextInt();
        SEARCH(k, num5);
    }

    private static void SEARCH(int k, A num5) {
        int i = 5;
        A top = num5;
        while (top.prev != null) {
            if (top.a == k) {
                System.out.println("Ваш элемент найден, его индекс  " + i);
                break;
            } else {
                top = top.prev;
                i--;
            }

        }
        if(top.prev==null){
            System.out.println("Элемент не найден :(");
        }
    }
}

