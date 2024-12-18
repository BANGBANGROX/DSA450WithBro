//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int rows=sc.nextInt();
            int columns=sc.nextInt();

            int[][] matrix =new int[rows][columns];

            for(int i=0; i<rows;i++){
                for(int j=0; j<columns;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.search(matrix, rows, columns, target))
                System.out.println(1);
            else
                System.out.println(0);
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    //Function to search a given number in row-column sorted matrix.
    public boolean search(int[][] matrix, int m, int n, int x) {
        // code here
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] <= x && matrix[i][n - 1] >= x) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == x) return true;
                }
            }
        }

        return false;
    }
}
