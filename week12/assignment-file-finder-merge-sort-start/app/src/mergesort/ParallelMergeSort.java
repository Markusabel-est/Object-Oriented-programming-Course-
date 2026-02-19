package mergesort;

import java.util.Arrays;

public class ParallelMergeSort {
    /**
     * sort the given array in O(N log N) time
     * The array is split in two parts of equal size.
     * These parts are sort recursively and merged.
     * @param array
     */
    public static void sort(int [] array) {
        if (array == null) {
            return;
        }
        if(array.length < 10000) {
            MergeSort.sort(array);
        }
        else{
            int [] firstHalf = Arrays.copyOf(array, array.length / 2);
            int [] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

            Thread thread1 = new Thread(() -> sort(firstHalf));
            Thread thread2 = new Thread(()-> sort(secondHalf));
            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MergeSort.merge(firstHalf, secondHalf, array);

        }
    }
}
