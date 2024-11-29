import java.util.Scanner;

class GuessGame {
    private final int pick;

    GuessGame(int pick) {
        this.pick = pick;
    }

    public int guess(int num) {
        return Integer.compare(pick, num);
    }
}

class Solution extends GuessGame {
    Solution(int pick) {
        super(pick);
    }

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
           System.out.println(new Solution(10).guessNumber(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
