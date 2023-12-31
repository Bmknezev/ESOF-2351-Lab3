package engi3255.sort;

public class QuickSortStd implements Sort{

    private int numComparisons = 0;
    @Override
    public void sort(Comparable[] a) {
        numComparisons = 0;
        quicksort(a, 0, a.length - 1);
    }

    private static final int CUTOFF = 10;

/**
 * Method to swap to elements in an array.
 *
 * @param a an array of objects.
 * @param index1 the index of the first object.
 * @param index2 the index of the second object.
 */
        public static final void swapReferences (Object[]a,int index1, int index2)
        {
            Object tmp = a[index1];
            a[index1] = a[index2];
            a[index2] = tmp;
        }

/**
 * Internal quicksort method that makes recursive calls.
 * Uses median-of-three partitioning and a cutoff of 10.
 *
 * @param a an array of Comparable items.
 * @param low the left-most index of the subarray.
 * @param high the right-most index of the subarray.
 */
        private void quicksort (Comparable[]a,int low, int high)
        {
            if (low + CUTOFF > high)
                insertionSort(a, low, high);
            else {
                // Sort low, middle, high
                int middle = (low + high) / 2;
                if (compare(a[middle], a[low]) < 0)
                    swapReferences(a, low, middle);
                if (compare(a[high],a[low]) < 0)
                    swapReferences(a, low, high);
                if (compare(a[high],a[middle]) < 0)
                    swapReferences(a, middle, high);

                // Place pivot at position high - 1
                swapReferences(a, middle, high - 1);
                Comparable pivot = a[high - 1];

                // Begin partitioning
                int i, j;
                for (i = low, j = high - 1; ; ) {
                    while (compare(a[++i],pivot)< 0)
                        ;
                    while (compare(pivot,a[--j])< 0)
                        ;
                    if (i >= j)
                        break;
                    swapReferences(a, i, j);
                }

                // Restore pivot
                swapReferences(a, i, high - 1);

                quicksort(a, low, i - 1);    // Sort small elements
                quicksort(a, i + 1, high);   // Sort large elements
            }
        }


        private void insertionSort (Comparable[]a,int low, int high)
        {
            for (int p = low + 1; p <= high; p++) {
                Comparable tmp = a[p];
                int j;

                for (j = p; j > low && compare(tmp, a[j-1]) < 0; j--)
                    a[j] = a[j - 1];
                a[j] = tmp;
            }
        }

    public int compare(Comparable a, Comparable b) {
        numComparisons++;
        return a.compareTo(b);
    }
    @Override
    public long getCompares() {
        return numComparisons;
    }
}