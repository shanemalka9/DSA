package Algorithms.Sort_Algorithms.QuickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = { 6, 5, 2, 8, 9, 3, 4 };

        System.out.println("Unsorted array: " + Arrays.toString(nums));
        System.out.println("Final output : " + Arrays.toString(quickSort(nums, 0, nums.length - 1)));
    }

    /**
     * Sorts an array using the QuickSort algorithm by recursively partitioning around a pivot.
     * @param arr the array to be sorted
     * @param low starting index
     * @param high ending index
     * @return the sorted array
     */
    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) { // base case: if the sub-array has more than one element
            int pivot = partition(arr, low, high); // partition the array and get pivot index

            quickSort(arr, low, pivot - 1); // recursively sort the left sub-array
            quickSort(arr, pivot + 1, high); // recursively sort the right sub-array
        }
        System.out.println(Arrays.toString(arr)); // print array at each step
        return arr;    
    }

    /**
     * Rearranges the array so that elements less than pivot are on the left, and greater on the right.
     * @param arr the array to be partitioned
     * @param low starting index
     * @param high ending index (pivot is chosen here)
     * @return the index where the pivot finally lies
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose the last element as pivot
        int i = low - 1; // pointer for the greater element

        for (int j = low; j <= high; j++) { // traverse through all elements
            if (arr[j] < pivot) { // if current element is less than pivot
                i++; // move pointer
                int temp = arr[i]; // swap arr[i] with arr[j]
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1]; // place pivot at correct position
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return pivot index
    }
}