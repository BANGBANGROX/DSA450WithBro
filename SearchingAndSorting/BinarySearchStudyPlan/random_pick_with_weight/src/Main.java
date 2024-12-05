import java.util.Scanner;

class Solution {
    private final int[] prefixSum;

    public Solution(int[] w) {
        int n = w.length;
        prefixSum = new int[n];

        prefixSum[0] = w[0];

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    private int lowerBound(int key) {
        int n = prefixSum.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = (l + ((r - l) >> 1));
            if (prefixSum[mid] <= key) l = mid + 1;
            else r = mid;
        }

        return l;
    }

    public int pickIndex() {
        int n = prefixSum.length;
        int key = (int)(Math.random() * (prefixSum[n - 1]));

        return lowerBound(key);
    }
}


public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();

       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] w = new int[n];
           for (int i = 0; i < n; ++i) {
               w[i] = scanner.nextInt();
           }

           Solution solution = new Solution(w);
           for (int i = 0; i < n; ++i) {
               System.out.println(solution.pickIndex());
           }
       }

       scanner.close();
   }
}
