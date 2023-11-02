package engi3255.sort;
public class BubbleSort implements Sort {
    private int numComparisons = 0;
    /**
     * Sort the array into ascending order
     *
     * @throws IllegalArgumentException if the argument is null
     */
    public void sort( Comparable [ ] a ) throws IllegalArgumentException
    {
        if (a == null) {
            throw new IllegalArgumentException("Cannot sort null");
        }
        boolean sorted = false;
        for (int last = a.length-1; (last >= 1) && (!sorted) ; last--)
        {
            sorted = true;
            for (int i =0; i<last; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    Comparable tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    sorted = false;
                }
                this.numComparisons++;
            }
        }
    }

    /**
     * Returns the number of compares used in sort
     *
     * @return Returns the number of compares used in sort
     */
    public long getCompares()
    {
        return this.numComparisons;
    }



}

