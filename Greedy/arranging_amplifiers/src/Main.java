import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    private void descendingOrderSort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        while (left < right) {
            nums[left] += nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
            ++left;
            --right;
        }
    }

    public List<Integer> getMaxScorePermutation(int[] nums) {
        int n = nums.length;
        int onesCnt = 0;
        List<Integer> answer = new ArrayList<>();

        descendingOrderSort(nums);

        for (int num : nums) {
            if (num == 1) {
                ++onesCnt;
            }
        }

        for (int i = 0; i < onesCnt; ++i) {
            answer.add(1);
        }

        if ((n - onesCnt) == 2 && nums[0] == 3 && nums[1] == 2) {
            answer.add(2);
            answer.add(3);
            return answer;
        }

        for (int i = 0; i < (n - onesCnt); ++i) {
            answer.add(nums[i]);
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

           List<Integer> answer = new Solution().getMaxScorePermutation(nums);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
