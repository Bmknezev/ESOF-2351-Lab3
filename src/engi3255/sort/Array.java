package engi3255.sort;

public class Array {
   private Integer[] arr;
   private int size;

    public Array(int arr) {
        this.size = arr;
        this.arr = new Integer[size];
    }

    public Integer[] getArray() {
        return arr;
    }

    public void setArray(Integer[] arr) {
        this.arr = arr;
    }

    public void randomizeArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }
    }

}
