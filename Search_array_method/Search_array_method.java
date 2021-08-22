package Array;
import java.util.Scanner;

public class Search_array_method {

    private static int top=-1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = in.nextInt();
        double[] dar = new double[n];
        System.out.println("Заполните массив: ");
        for (int i = 0; i < dar.length; i++) {
            dar[i] = in.nextDouble();
            top++;

        }
        SEARCH(dar);
    }

    private static void SEARCH(double[] dar){
            System.out.print("Введите значение массива, которое требуется найти: ");
            Scanner in=new Scanner(System.in);
            double k=in.nextDouble();
            while (top!=-1){
                if (dar[top]==k) {
                    System.out.println("Мы нашли ваш элемент, его индекс - [" +top+ "]");
                    break;
                }
                else top--;

                if (top==-1){
                    System.out.println("Упс! Такого элемента не существует:( ");
                }
            }


        }

    }
