package engi3255.sort;
public class CocktailSort implements Sort{
    private int numComparisons = 0;
    @Override
    public void sort(Comparable[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Cannot sort null");
        }
        boolean swapped = true;
        int start = 0;
        int end = a.length;
        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    Comparable temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
                numComparisons++;
            }
            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    Comparable temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
                numComparisons++;
            }
            start = start + 1;
        }
    }

    @Override
    public long getCompares() {
        return numComparisons;
    }
}
