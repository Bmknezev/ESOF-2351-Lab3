import java.util.Random;
import engi3255.sort.*;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = new Integer[7];
        Random rand = new Random();

        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt();
        }

        BubbleSort bubble = new BubbleSort();
        SelectionSort select = new SelectionSort();
        CocktailSort cocktail = new CocktailSort();

        bubble.sort(arr);
        System.out.println(bubble.getCompares());

        select.sort(arr);
        System.out.println(select.getCompares());

        cocktail.sort(arr);
        System.out.println(cocktail.getCompares());

    }
}