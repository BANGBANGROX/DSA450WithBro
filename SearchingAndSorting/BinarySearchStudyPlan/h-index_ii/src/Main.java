import java.util.Scanner;

class Solution {
    private int[] citations;
    private int n;

    private int lowerBound(int val) {
        int left = 0;
        int right = n - 1;
        int result = n;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (citations[mid] >= val) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int hIndex(int[] citations) {
        this.citations = citations;
        n = citations.length;
        int left = 0;
        int right = n;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            int idx = lowerBound(mid);
            int totalCitations = n - idx;
            if (totalCitations >= mid) {
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
           int[] citations = new int[n];
           for (int i = 0; i < n; ++i) {
               citations[i] = scanner.nextInt();
           }

           System.out.println(new Solution().hIndex(citations));
       }
       
       scanner.close();
   }
}
