//{ Driver Code Starts
// Initial Template for Java

import java.util.ArrayList;
import java.util.Scanner;


// } Driver Code Ends
// User function Template for Java

class Solution {
    private int multiply(int num, int[] result, int size) {
        int carry = 0;

        for (int i = 0; i < size; ++i) {
            int val = result[i] * num + carry;
            result[i] = val % 10;
            carry = val / 10;
        }

        while (carry > 0) {
            result[size] = carry % 10;
            carry /= 10;
            ++size;
        }

        return size;
    }

    public ArrayList<Integer> factorial(int n) {
        // code here
        final int MAX_SIZE = (int) 1e6 + 5;
        int[] result = new int[MAX_SIZE];
        int currentSize = 1;
        ArrayList<Integer> answer = new ArrayList<>();

        result[0] = 1;

        for (int i = 2; i <= n; ++i) {
            currentSize = multiply(i, result, currentSize);
        }

        for (int i = currentSize - 1; i >= 0; --i) {
            answer.add(result[i]);
        }

        return answer;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val);
            System.out.println();
        }
    }
}
// } Driver Code Ends