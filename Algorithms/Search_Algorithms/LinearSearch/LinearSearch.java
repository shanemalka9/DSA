package Algorithms.Search_Algorithms.LinearSearch;
import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        // Initialization
        Scanner input = new Scanner(System.in);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Get Inputs
        System.out.print("Enter value to search: ");
        int target = input.nextInt();
        input.close();

        // Call method
        linearSearch(nums, target);
    }

    private static void linearSearch(int[] nums, int target){
        for(int  i = 0;  i < nums.length; i++) { // Iterate from 0 until the length of the array - 1
            if (nums[i] == target) { // Check if the target value is present
                System.out.println("Target is at " + i + " index."); // if present print
            }
        }
        System.out.println("Value Not Found"); // If not present then say no
    }
}