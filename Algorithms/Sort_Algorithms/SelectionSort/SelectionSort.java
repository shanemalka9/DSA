package Sort_Algorithms.SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {6, 5, 2, 8, 9, 3, 4};

        System.out.println("Final output of minSelectionSort: " + Arrays.toString(minSelectionSort(nums.clone())));
        System.out.println("Final output of maxSelectionSort: " + Arrays.toString(maxSelectionSort(nums.clone())));
    }

    /**
     * Repeatedly finds the smallest element from the unsorted part and swaps it with the first unsorted element.
     * @param arr
     * @return
     */
    private static int[] minSelectionSort(int[] arr) {
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * Repeatedly finds the largest element from the unsorted part and swaps it with the last unsorted element.
     * @param arr
     * @return
     */
    private static int[] maxSelectionSort(int[] arr) {
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, n - 1 - i);
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}