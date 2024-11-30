import java.util.Scanner;

class Solution {
    private int[] arr;
    private int n;

    private int getIndex(int val) {
        int left = 0;
        int right = n - 1;
        int result = 0;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (arr[mid] <= val) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int findKthPositive(int[] arr, int k) {
        n = arr.length;
        int totalMissing = arr[n - 1] - n;
        int firstMissing = arr[0] - 1;

        if (k <= firstMissing) {
            return k;
        }

        if (totalMissing < k) {
            return arr[n - 1] + k - totalMissing;
        }

        this.arr = arr;
        int left = 1;
        int right = arr[n - 1];
        int answer = -1;
        --k;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            int idx = getIndex(mid);
            int missing = arr[idx] - idx - 1 + mid - arr[idx] - 1;
            if (missing >= k) {
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
           int n = scanner.nextInt();
           int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }
           int k = scanner.nextInt();

           System.out.println(new Solution().findKthPositive(arr, k));
       }
       
       scanner.close();
   }
}
