package BinarySearch;

import java.util.Scanner;

/**
 * For this to work the array should be sorted
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.print("Enter value to search: ");
        int target = input.nextInt();
        input.close();

        int output = binarySearch(nums, target, true); // Call the method and returns a value
        System.out.println(output); // Prints the value
    }

    private static int binarySearch(int[] nums, int target, boolean rec) {
        // Initialize the fisrt and last values
        int first = 0;
        int last = nums.length - 1;

        if (rec) {
            return binarySearchRecurssion(nums, target, first, last);
        } else {

            while (first <= last) {

                int mid = ((first + last) / 2); // Initialize the middle value

                if (nums[mid] == target) { // If middle return mid
                    return mid;
                } else if (target > nums[mid]) { // If target greater than middle make mid + 1 as first
                    first = mid + 1;
                } else {
                    last = mid - 1; // else make mid - 1 as last
                }
            }
            return -1;
        }
    }

    private static int binarySearchRecurssion(int[] nums, int target, int first, int last) {
        int mid = ((first + last) / 2); // Initialize the middle value

        if (nums[mid] == target) { // If middle return mid
            return mid;
        } else if (target > nums[mid]) { // If target greater than middle make mid + 1 as first
            binarySearchRecurssion(nums, target, mid + 1, last);
        } else {
            binarySearchRecurssion(nums, target, first, mid - 1); // else make mid - 1 as last
        }
        return -1;
    }
}
