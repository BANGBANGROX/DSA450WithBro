import java.util.Scanner;

class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            long square = (long) mid * mid;
            if (square == x) return mid;
            if (square > x) {
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
           System.out.println(new Solution().mySqrt(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
