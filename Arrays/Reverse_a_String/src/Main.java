//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str = read.readLine();
            System.out.println(new Reverse().reverseString(str));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Reverse {
    // Complete the function
    // str: input string
    public String reverseString(String s) {
        // Reverse the string str
        char[] sArray = s.toCharArray();
        int left = 0;
        int right = sArray.length - 1;

        while (left < right) {
            char ch = sArray[left];
            sArray[left] = sArray[right];
            sArray[right] = ch;
            ++left;
            --right;
        }

        return new String(sArray);
    }
}