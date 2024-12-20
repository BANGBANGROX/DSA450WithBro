import java.util.Scanner;
import java.util.Arrays;

class Solution {
    private int countValidPotions(int[] potions, long val) {
        int n = potions.length;
        int l = 0;
        int r = n - 1;
        int ans = n;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (potions[mid] < val) l = mid + 1;
            else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
    }

    public int[] successfulPairs(int[] spells, int[] potions,
                                 long success) {
        int m = spells.length;
        int n = potions.length;
        int[] ans = new int[m];

        Arrays.sort(potions);

        for (int i = 0; i < m; ++i) {
            long val = (long) Math.ceil((double) success / spells[i]);
            int cnt = countValidPotions(potions, val);
            ans[i] = n - cnt;
        }

        return ans;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int[] spells = new int[m];
           for (int i = 0; i < m; ++i) {
               spells[i] = scanner.nextInt();
           }
           int n = scanner.nextInt();
           int[] potions = new int[n];
           for (int i = 0; i < n; ++i) {
               potions[i] = scanner.nextInt();
           }
           long success = scanner.nextLong();

           int[] answer = new Solution().successfulPairs(spells, potions, success);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
