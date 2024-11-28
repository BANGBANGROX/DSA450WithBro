import java.util.Scanner;

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        if (n == 1 || nums[0] < nums[n - 1]) return nums[0];

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] == nums[right]) --right;
            else right = mid - 1;
        }

        return nums[left];
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().findMin(nums));
       }
       
       scanner.close();
   }
}
