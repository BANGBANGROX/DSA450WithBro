import java.util.Scanner;

class Solution {
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            long value = (long) mid * (mid + 1) / 2;
            if (value == n) return mid;
            if (value > n) {
                right = mid - 1;
            } else {
                answer = mid;
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
           System.out.println(new Solution().arrangeCoins(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
