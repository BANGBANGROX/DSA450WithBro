import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;

        if (n < 3) return 0;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) {
            // We consider 3 edges
            // a = nums[i]
            // b = nums[i+1] or nums[j]
            // c = nums[i+2] or nums[k]
            int k = i + 2;
            for (int j = i + 1; j < n - 1 && nums[i] != 0; ++j) {
                while (k < n && nums[k] < nums[i] + nums[j]) ++k;
                ans += (k - (j + 1));
            }
        }

        return ans;
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

           System.out.println(new Solution().triangleNumber(nums));
       }
       
       scanner.close();
   }
}
