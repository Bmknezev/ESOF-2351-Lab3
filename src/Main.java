import engi3255.sort.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{23, 8, 6, 5, 4, 2, 1};
        Array array = new Array(50);
        array.randomizeArray();
        int[] arr2 = new int[]{23,8, 6, 5, 4, 2, 1};


        AnalyzerImpl analyzer = new AnalyzerImpl();

        BubbleSort bubble = new BubbleSort();
        SelectionSort select = new SelectionSort();
        QuickSortStd quick = new QuickSortStd();
        InsertionSort insert = new InsertionSort();

        Sort[] sorts = new Sort[]{bubble, select, quick, insert};

        int[] sizes = new int[]{50,50,50,50,50,50,50};
        long[] data = new long[7];

        for (Sort sort : sorts) {
            for (int j = 0; j < 7; j++) {
                array.randomizeArray();
                sort.sort(array.getArray());
                data[j] = sort.getCompares();
            }
            analyzer.analyze(sizes, data);
            System.out.println(sort.getClass().getName());
            System.out.println("Big Oh: " + analyzer.getBigOh());
            System.out.printf("Error: %.2f\n", analyzer.getError());
            System.out.println("Ratios: " + Arrays.toString(analyzer.getRatios()));
            System.out.println();

        }

    }
}