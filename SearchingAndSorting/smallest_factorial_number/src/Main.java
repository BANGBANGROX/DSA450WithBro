//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            System.out.println(new Solution().findNum(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int n;

    private boolean check(int num) {
        long val = 5;
        long cnt = 0;

        while (val <= num) {
            cnt += num / val;
            if (cnt >= n) return true;
            val *= 5;
        }

        return false;
    }

    public int findNum(int n) {
        // Complete this function
        this.n = n;
        int left = 0;
        int right = (int) 1e9;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}