package Algorithms.Sort_Algorithms.InsertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = { 6, 5, 2, 8, 9, 3, 4 };

        System.out.println("Sorted array using insertion sort : " + Arrays.toString( insertionSort(nums)));
    }

    /**
     * Builds a sorted array by picking elements one by one and inserting them into their correct position.
     * @param arr
     * @return
     */
    private static int[] insertionSort(int[] arr) {
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        int n = arr.length;

        for (int i = 1; i < n; i++) { // Loop through the array fom position 1
            int key = arr[i]; // Add the value at position 1 as a key
            int j = i - 1; // create a vaiable j which is 1 less than i
            while (j >= 0 && arr[j] > key) { // Iterate if j is greater than i and j greater than or equal to zero
                arr[j + 1] = arr[j]; // shift value to the right
                j--; // reduce j
            }
            arr[j + 1] = key; // add key to empty position
            System.out.println(Arrays.toString(arr));
       }
       return arr;
    }
}
