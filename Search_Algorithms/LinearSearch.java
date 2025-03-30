import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.print("Enter value to search: ");
        int target = input.nextInt();
        input.close();
        linearSearch(nums, target);
    }

    private static void linearSearch(int[] nums, int target){
        for(int  i = 0;  i < nums.length; i++) {
            if (nums[i] == target) {
                System.out.println("Target is at " + i + " index.");
            }
        }
        System.out.println("Value Not Found");
    }
}