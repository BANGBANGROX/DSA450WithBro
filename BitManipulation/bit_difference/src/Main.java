//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;


// } Driver Code Ends
//User function Template for Java

class Solution {
    // Function to find number of bits needed to be flipped to convert A to B
    public int countBitsFlip(int a, int b) {
        // Your code here
        int answer = 0;
        int xor = a ^ b;

        for (int i = 0; i < 32; ++i) {
            if ((xor & (1 << i)) > 0) {
                ++answer;
            }
        }

        return answer;
    }
}


//{ Driver Code Starts.

// Driver class
public class Main {
    public static void main(String[] args) throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        int m, n;
        // initialise ans to 0
        while (t-- > 0) {

            //input m and n
            m = sc.nextInt();
            n = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.countBitsFlip(m, n));

            System.out.println("~");
        }
    }
}


// } Driver Code Ends