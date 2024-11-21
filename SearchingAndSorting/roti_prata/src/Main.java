import java.util.Scanner;

class Solution {
    private int totalPratas;
    private int[] rank;

    private boolean check(int time) {
        int cnt = 0;

        for (int currentRank : rank) {
            if (currentRank > time) continue;
            int start = currentRank;
            int mul = 2;
            while (start <= time) {
                ++cnt;
                if (cnt >= totalPratas) return true;
                start += mul * currentRank;
                ++mul;
            }
        }

        return false;
    }

    public int getMinTimeForCookingPratas(int totalPratas, int[] rank) {
        this.totalPratas = totalPratas;
        this.rank = rank;
        int left = 0;
        int right = (int) 1e9;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
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
           int totalPratas = scanner.nextInt();
           int n = scanner.nextInt();
           int[] rank = new int[n];
           for (int i = 0; i < n; ++i) {
               rank[i] = scanner.nextInt();
           }

           System.out.println(new Solution().getMinTimeForCookingPratas(totalPratas, rank));
       }
       
       scanner.close();
   }
}
