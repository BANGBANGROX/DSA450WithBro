import java.util.Scanner;

class Solution {
    public int maxChicksToLift(int[] positions, int[] speeds,
                               int destination, int totalTime, int k) {
        int answer = 0;
        int slowChicks = 0;
        int n = positions.length;
        int passed = 0;

        for (int i = n - 1; i >= 0 && passed < k; --i) {
            long lastPoint = (long) speeds[i] * totalTime + positions[i];
            if (lastPoint < destination) {
                ++slowChicks;
            } else {
                answer += slowChicks;
                ++passed;
            }
        }

        return passed < k ? -1 : answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       for (int test = 1; test <= testCases; ++test) {
           int n = scanner.nextInt();
           int k = scanner.nextInt();
           int destination = scanner.nextInt();
           int totalTime = scanner.nextInt();
           int[] positions = new int[n];
           for (int i = 0; i < n; ++i) {
               positions[i] = scanner.nextInt();
           }
           int[] speeds = new int[n];
           for (int i = 0; i < n; ++i) {
               speeds[i] = scanner.nextInt();
           }

           int answer = new Solution().maxChicksToLift(positions, speeds, destination,
                   totalTime, k);
           System.out.println("Case #" + test + ": " + (answer != -1 ? answer : "IMPOSSIBLE"));
       }
       
       scanner.close();
   }
}
