//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int[][] matrix = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int firstRow = 0;
        int lastRow = m - 1;
        int firstCol = 0;
        int lastCol = n - 1;
        ArrayList<Integer> answer = new ArrayList<>();

        while (firstRow < lastRow && firstCol < lastCol) {
            for (int i = firstCol; i <= lastCol; ++i) {
                answer.add(mat[firstRow][i]);
            }
            ++firstRow;
            for (int i = firstRow; i <= lastRow; ++i) {
                answer.add(mat[i][lastCol]);
            }
            --lastCol;
            for (int i = lastCol; i >= firstCol; --i) {
                answer.add(mat[lastRow][i]);
            }
            --lastRow;
            for (int i = lastRow; i >= firstRow; --i) {
                answer.add(mat[i][firstCol]);
            }
            ++firstCol;
        }

        if (firstRow == lastRow) {
            for (int i = firstCol; i <= lastCol; ++i) {
                answer.add(mat[firstRow][i]);
            }
        } else if (firstCol == lastCol) {
            for (int i = firstRow; i <= lastRow; ++i) {
                answer.add(mat[i][firstCol]);
            }
        }

        return answer;
    }
}
