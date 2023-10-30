public class InsertionSort implements Sort {
    private int numComparisons = 0;

    @Override
    public void sort(Comparable[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Cannot sort null");
        }
        int n = a.length;

        for (int i = 1; i < n; i++) {
            Comparable key = a[i];
            int j = i - 1;

            // Move elements of a[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
            numComparisons++;
        }
    }

    @Override
    public long getCompares() {
        return numComparisons;
    }
}
