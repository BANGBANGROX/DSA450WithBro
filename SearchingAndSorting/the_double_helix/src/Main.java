import java.util.Scanner;

class Solution {
    public int findMaxSum(int[] first, int[] second) {
        int m = first.length;
        int n = second.length;
        int i = 0;
        int j = 0;
        int answer = 0;
        int firstSum = 0;
        int secondSum = 0;

        while (i < m || j < n) {
            if (i == m) {
                while (j < n) {
                    secondSum += second[j];
                    ++j;
                }
            } else if (j == n) {
                while (i < m) {
                    firstSum += first[i];
                    ++i;
                }
            } else if (first[i] < second[j]) {
                firstSum += first[i];
                ++i;
            } else if (first[i] > second[j]) {
                secondSum += second[j];
                ++j;
            } else {
                answer += Math.max(firstSum, secondSum);
                firstSum = secondSum = first[i];
                ++i;
                ++j;
            }
        }

        answer += Math.max(firstSum, secondSum);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       while (true) {
           int m = scanner.nextInt();
           if (m == 0) break;
           int[] first = new int[m];
           for (int i = 0; i < m; ++i) {
               first[i] = scanner.nextInt();
           }
           int n = scanner.nextInt();
           int[] second = new int[n];
           for (int i = 0; i < n; ++i) {
               second[i] = scanner.nextInt();
           }

           System.out.println(new Solution().findMaxSum(first, second));
       }
       
       scanner.close();
   }
}
