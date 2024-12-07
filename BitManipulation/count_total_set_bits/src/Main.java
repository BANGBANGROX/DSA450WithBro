//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;


// } Driver Code Ends
//User function Template for Java

class Solution {
    private int getClosestPowerOf2(int num) {
        int result = 0;

        while (num > 0) {
            num >>= 1;
            if (num > 0) ++result;
        }

        return result;
    }

    //Function to return sum of count of set bits in the integers from 1 to n.
    public int countSetBits(int n) {
        // Your code here
        if (n == 0) return 0;

        int power = getClosestPowerOf2(n);

        return power * (1 << (power - 1)) + n - (1 << power) + 1 +
                countSetBits(n - (1 << power));
    }
}

//{ Driver Code Starts.

// Driver code
public class Main {
    public static void main(String[] args) throws NumberFormatException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();//testcases
        int n;
        while(t-->0) {
            n = sc.nextInt();//input n

            Solution obj = new Solution();

            System.out.println(obj.countSetBits(n));//calling countSetBits() method

            System.out.println("~");
        }
    }
}

// } Driver Code Ends