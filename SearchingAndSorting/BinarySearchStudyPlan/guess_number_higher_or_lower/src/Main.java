import java.util.Scanner;

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            int result = guess(mid);
            if (result == 0) return mid;
            else if (result == -1) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().guessNumber(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
