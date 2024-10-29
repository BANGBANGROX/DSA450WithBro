//{ Driver Code Starts

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().maxArea(arr, n, m));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    private int maxRectangleInArray(int[] nums, int n) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int idx = stack.pop();
                int previousSmaller = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, nums[idx] * (i - previousSmaller - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int previousSmaller = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, nums[idx] * (n - previousSmaller - 1));
        }

        return maxArea;
    }

    public int maxArea(int[][] matrix, int m, int n) {
        // add code here.
        int answer = maxRectangleInArray(matrix[0], n);

        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            answer = Math.max(answer, maxRectangleInArray(matrix[i], n));
        }

        return answer;
    }
}