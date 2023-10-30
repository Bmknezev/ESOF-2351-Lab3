import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Integer[] arr = new Integer[7];
        Random rand = new Random();

        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt();
        }

        BubbleSort bubble = new BubbleSort();
        SelectionSort select = new SelectionSort();

        bubble.sort(arr);
        System.out.println(bubble.getCompares());

        select.sort(arr);
        System.out.println(select.getCompares());


    }
}