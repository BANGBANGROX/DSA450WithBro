import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private void descendingSort(int[] nums) {
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

    public long getMinCost(int[] x, int[] y) {
        int m = x.length;
        int n = y.length;
        long answer = 0;
        int verticalPieces = 1;
        int horizontalPieces = 1;
        int i = 0;
        int j = 0;

        descendingSort(x);
        descendingSort(y);

        while (i < m && j < n) {
            if (x[i] > y[j]) {
                answer += ((long) x[i] * verticalPieces);
                ++horizontalPieces;
                ++i;
            } else {
                answer += ((long) y[j] * horizontalPieces);
                ++verticalPieces;
                ++j;
            }
        }

        long totalLeft = 0;

        while (i < m) {
            totalLeft += x[i];
            ++i;
        }

        answer += (totalLeft * verticalPieces);
        totalLeft = 0;

        while (j < n) {
            totalLeft += y[j];
            ++j;
        }

        answer += (totalLeft * horizontalPieces);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt() - 1;
           int n = scanner.nextInt() - 1;
           int[] x = new int[m];
           int[] y = new int[n];
           for (int i = 0; i < m; ++i) {
               x[i] = scanner.nextInt();
           }
           for (int i = 0; i < n; ++i) {
               y[i] = scanner.nextInt();
           }

           System.out.println(new Solution().getMinCost(x, y));
       }
       
       scanner.close();
   }
}
