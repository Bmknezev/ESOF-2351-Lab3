package engi3255.sort;

public class QuickSort implements Sort{
    private int numComparisons = 0;
    @Override
    public void sort(Comparable[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Cannot sort null");
        }
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    private int partition(Comparable[] a, int low, int high) {
        Comparable pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) < 0) {
                i++;
                Comparable temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            numComparisons++;
        }
        Comparable temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return (i+1);
    }

    @Override
    public long getCompares() {
        return numComparisons;
    }
}
