import java.util.Scanner;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        if (nums[0] != nums[1]) return nums[0];

        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            int leftSideElements = mid + 1;
            if (nums[mid] == nums[mid - 1]) --leftSideElements;
            if ((leftSideElements & 1) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
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

           System.out.println(new Solution().singleNonDuplicate(nums));
       }
       
       scanner.close();
   }
}
