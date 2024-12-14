import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int getUndefendedRectangles(int[] rows, int[] cols) {
        int totalTowers = rows.length;
        int maxRowGap = 0;
        int maxColGap = 0;

        Arrays.sort(rows);
        Arrays.sort(cols);

        for (int i = 1; i < totalTowers; ++i) {
            maxRowGap = Math.max(maxRowGap, rows[i] - rows[i - 1] - 1);
            maxColGap = Math.max(maxColGap, cols[i] - cols[i - 1] - 1);
        }

        return maxRowGap * maxColGap;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           int totalTowers = scanner.nextInt() + 2;
           int[] rows = new int[totalTowers];
           int[] cols = new int[totalTowers];

           rows[0] = 0;
           cols[0] = 0;
           rows[totalTowers - 1] = m + 1;
           cols[totalTowers - 1] = n + 1;

           for (int i = 1; i < totalTowers - 1; ++i) {
               rows[i] = scanner.nextInt();
               cols[i] = scanner.nextInt();
           }

           System.out.println(new Solution().getUndefendedRectangles(rows, cols));
       }
       
       scanner.close();
   }
}
