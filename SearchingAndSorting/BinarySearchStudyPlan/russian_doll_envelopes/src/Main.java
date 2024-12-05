import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    private List<Integer> dp;

    private int lowerBound(int key) {
        int left = 0;
        int right = dp.size() - 1;
        int result = right + 1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (dp.get(mid) >= key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int maxEnvelopes(int[][] envelopes) {
        dp = new ArrayList<>();

        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        for (int[] envelope : envelopes) {
            int idx = lowerBound(envelope[1]);
            if (idx == dp.size()) {
                dp.add(envelope[1]);
            } else {
                dp.set(idx, envelope[1]);
            }
        }

        return dp.size();
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[][] envelopes = new int[n][2];
           for (int i = 0; i < n; ++i) {
               envelopes[i][0] = scanner.nextInt();
               envelopes[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().maxEnvelopes(envelopes));
       }
       
       scanner.close();
   }
}
