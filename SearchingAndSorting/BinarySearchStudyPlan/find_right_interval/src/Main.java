import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    private int[][] startSortedIntervals;

    private int getRightInterval(int end) {
        int left = 0;
        int right = startSortedIntervals.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (startSortedIntervals[mid][0] >= end) {
                result = startSortedIntervals[mid][1];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        startSortedIntervals = new int[n][2];
        int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            startSortedIntervals[i][0] = intervals[i][0];
            startSortedIntervals[i][1] = i;
        }

        Arrays.sort(startSortedIntervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; ++i) {
            answer[i] = getRightInterval(intervals[i][1]);
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
           int[][] intervals = new int[n][2];
           for (int i = 0; i < n; ++i) {
               intervals[i][0] = scanner.nextInt();
               intervals[i][1] = scanner.nextInt();
           }
           int[] answer = new Solution().findRightInterval(intervals);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
