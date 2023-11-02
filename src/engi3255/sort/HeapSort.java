package engi3255.sort;
public class HeapSort implements Sort{

    private int numComparisons = 0;

    @Override
    public void sort(Comparable[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Cannot sort null");
        }
        int n = a.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Comparable temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }

    private void heapify(Comparable[] a, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && a[left].compareTo(a[largest]) > 0) {
            largest = left;
        }
        numComparisons++;

        // If right child is larger than largest so far
        if (right < n && a[right].compareTo(a[largest]) > 0) {
            largest = right;
        }
        numComparisons++;

        // If largest is not root
        if (largest != i) {
            Comparable swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(a, n, largest);
        }
    }

    @Override
    public long getCompares() {
        return numComparisons;
    }
}
