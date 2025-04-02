package Sort_Algorithms.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 6, 5, 2, 8, 9, 3, 4 };

        System.out.println("Final output : " + Arrays.toString(bubbleSort(nums)));
    }

    /**
     * Repeatedly swaps adjacent elements if they are in the wrong order, pushing the largest element to the end in each pass.
     * @param arr
     * @return
     */
    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Loop through thea array multiple times to sort
            boolean sorted = true;

            for (int j = 0; j < arr.length - i - 1; j++) { // Loop through the elements to swap
                if (arr[j] > arr[j + 1]) {
                    sorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println(Arrays.toString(arr));

            if (sorted) {
                return arr;
            }
        }
        return arr;
    }
}
