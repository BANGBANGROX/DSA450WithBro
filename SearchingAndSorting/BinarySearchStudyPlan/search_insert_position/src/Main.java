import java.util.Scanner;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = nums.length;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] >= target) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
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
           int target = scanner.nextInt();

           System.out.println(new Solution().searchInsert(nums, target));
       }
       
       scanner.close();
   }
}
