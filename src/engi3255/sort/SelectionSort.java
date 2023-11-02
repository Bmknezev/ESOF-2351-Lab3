package engi3255.sort;
public class SelectionSort implements Sort {
    private int numComparisons = 0;

    @Override
    public void sort(Comparable[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Cannot sort null");
        }
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[minIndex]) > 0) {
                    minIndex = j;
                }
                numComparisons++;
            }

            // Swap the minimum element with the first element of the unsorted part
            Comparable temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
    @Override
    public long getCompares() {
        return numComparisons;
    }
}
