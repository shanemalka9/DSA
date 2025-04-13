package Sort_Algorithms.MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 6, 5, 2, 8, 9, 3, 4 };

        // Print the unsorted array
        System.out.println("Unsorted Array at beginning: " + Arrays.toString(nums));
        // Print the sorted array after applying mergeSort
        System.out.println("\nFinal output of mergeSort: " + Arrays.toString(mergeSort(nums, 0, nums.length - 1)));
    }

    /**
     * Recursively sorts an array using the MergeSort algorithm by splitting it into halves.
     * @param arr the array to be sorted
     * @param left the starting index of the current sub-array
     * @param right the ending index of the current sub-array
     * @return the sorted array
     */
    private static int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) { // Continue if the sub-array has more than one element
            int mid = (left + right) / 2; // Find the middle index of the array

            mergeSort(arr, left, mid); // Recursively sort the left sub-array
            mergeSort(arr, mid + 1, right); // Recursively sort the right sub-array

            merge(arr, left, mid, right); // Merge the two sorted halves together
        }
        return arr;
    }

    /**
     * Merges two sorted sub-arrays of arr into one sorted segment.
     * @param arr the original array containing the sub-arrays
     * @param left starting index of the first sub-array
     * @param mid ending index of the first sub-array; mid+1 is the start of the second sub-array
     * @param right ending index of the second sub-array
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int l1 = mid - left + 1; // Number of elements in the left sub-array
        int l2 = right - mid;    // Number of elements in the right sub-array

        // Create temporary arrays to hold the elements of the sub-arrays
        int[] leftArray = new int[l1];
        int[] rightArray = new int[l2];

        // Copy elements into leftArray
        for (int i = 0; i < l1; i++) {
            leftArray[i] = arr[left + i];
        }

        // Copy elements into rightArray
        for (int i = 0; i < l2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        int i = 0; // Initial index for leftArray
        int j = 0; // Initial index for rightArray
        int k = left; // Starting index for merged segment in arr

        // Merge the temporary arrays back into arr in sorted order
        while (i < l1 && j < l2) {
            if (leftArray[i] <= rightArray[j]) { // Choose element from leftArray if smaller or equal
                arr[k] = leftArray[i];
                i++;
            } else { // Choose element from rightArray if smaller
                arr[k] = rightArray[j];
                j++;
            }
            k++; // Move to the next position in arr
        }

        // Copy any remaining elements from leftArray, if any
        while (i < l1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray, if any
        while (j < l2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        System.out.println("\nLeft array: " + Arrays.toString(leftArray) + " | Right array: " + Arrays.toString(rightArray));
        System.out.println("In Sorting: " + Arrays.toString(arr));

    }
}
