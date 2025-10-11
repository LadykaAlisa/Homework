package homework1;

import java.util.Random;

//TODO: Write bubble sort

public class BubbleSort {

    public static void main(String[] args) {

        int[] bubbleSort = new int[10];
        Random rand = new Random();
        for (int i = 0; i < bubbleSort.length; i++) {
            bubbleSort[i] = rand.nextInt(50);
        }

        System.out.println("Рандомні числа:");
        for (int number : bubbleSort) {
            System.out.println( number );
        }

        for (int i = 0; i < bubbleSort.length - 1; i++) {
            for ( int x = 0; x < bubbleSort.length - 1 - i; x++) {
                if (bubbleSort[x] > bubbleSort[x + 1]) {
                    int newArr  = bubbleSort[x];
                    bubbleSort[x] = bubbleSort[x + 1];
                    bubbleSort[x + 1] = newArr;
                }
            }
        }
        System.out.println("Відсортовані числа:");
        for (int number : bubbleSort) {
            System.out.println(number);
        }
    }
}
