package HeapSort;

import java.util.Scanner;
import java.util.Arrays;

public class Heap_Sort {

    private static int size;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Введите размер массива : ");
        int Size = input.nextInt();
        System.out.println("Введите значения: ");
        int[] dar = new int[Size];
        for (int i = 0; i<Size; i++){
            dar[i]=input.nextInt();
        }
        dar=Heapsort1(dar);
        System.out.println("Отсортированный массив: "+Arrays.toString(dar));
    }

    private static void Build_Max_Heap(int[] dar){
        for (int i = (dar.length-1)/2; i >=0; i--) {
            dar = Max_Heapify(dar, i);
        }
        System.out.println("Куча: "+Arrays.toString(dar));
    }

    private static int[]  Max_Heapify(int[] F, int i){
        int largest;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<size &&F[i]<F[l]) {
            largest = l;
        }
        else largest =i;
        if(r<size && F[r]>F[largest]){
            largest=r;
        }
        if (largest!=i){
            int Memory = F[i];
            F[i]=F[largest];
            F[largest]=Memory;
            Max_Heapify(F,largest);
        }
        return F;
    }

    private static int[]  Heapsort1(int[] dar){
        size=dar.length;
        Build_Max_Heap(dar);
        for (int i = dar.length-1; i >0 ; i--) {
            int Memory = dar[0];
            dar[0]=dar[i];
            dar[i]=Memory;
            size=size-1;
            dar=Max_Heapify(dar,0);
        }
        return dar;
    }
}