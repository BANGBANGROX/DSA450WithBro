import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] stallPositions;
    private int numCows;

    private boolean check(int distance) {
        int minNextPosition = stallPositions[0] + distance;
        int cowsLeft = numCows;

        --cowsLeft;

        if (cowsLeft == 0) return true;

        for (int i = 1; i < stallPositions.length; ++i) {
            if (stallPositions[i] >= minNextPosition) {
                --cowsLeft;
                if (cowsLeft == 0) return true;
                minNextPosition = stallPositions[i] + distance;
            }
        }

        return false;
    }

    public int findMaxDistance(int[] stallPositions, int numCows) {
        this.stallPositions = stallPositions;
        this.numCows = numCows;

        Arrays.sort(this.stallPositions);

        int left = 0;
        int right = stallPositions[stallPositions.length - 1] - stallPositions[0];
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
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
           int n = scanner.nextInt();
           int numCows = scanner.nextInt();
           int[] stallPositions = new int[n];
           for (int i = 0; i < n; ++i) {
               stallPositions[i] = scanner.nextInt();
           }

           System.out.println(new Solution().findMaxDistance(stallPositions, numCows));
       }
       
       scanner.close();
   }
}
