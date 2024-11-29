import java.util.Scanner;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            int col = mid % n;
            int row = (mid - col) / n;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) {
                if (matrix[row][0] > target) {
                    if (row == 0) return false;
                    right = (row - 1) * n + n - 1;
                } else {
                    if (col == 0) return false;
                    right = row * n + col - 1;
                }
            } else {
                if (matrix[row][n - 1] < target) {
                    if (row == m - 1) return false;
                    left = (row + 1) * n;
                } else {
                    if (col == n - 1) return false;
                    left = row * n + col + 1;
                }
            }
        }

        return false;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           int[][] matrix = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   matrix[i][j] = scanner.nextInt();
               }
           }
           int target = scanner.nextInt();

           System.out.println(new Solution().searchMatrix(matrix, target));
       }
       
       scanner.close();
   }
}
