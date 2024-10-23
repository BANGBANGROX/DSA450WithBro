//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            //size of array
            int n = Integer.parseInt(read.readLine());
            long[] arr = new long[n];

            String[] str = read.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(str[i]);

            // StringBuffer sb = new StringBuffer();

            Solution ob = new Solution();

            //calling rearrange() function
            ob.rearrange(arr, n);
            StringBuffer sb = new StringBuffer();

            //appending and printing the elements
            for (int i = 0; i < n; i++)
                sb.append(arr[i]).append(" ");
            System.out.println(sb);
        }
    }
}




// } Driver Code Ends


class Solution {
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public void rearrange(long[] arr, int n) {
        // Your code here
        int left = 0;
        int right = n - 1;
        int i = 0;
        long[] answer = new long[n];

        if (n == 1) return;

        while (left < right) {
            answer[i] = arr[right];
            answer[i + 1] = arr[left];
            --right;
            ++left;
            i += 2;
        }

        if (left == right) answer[n - 1] = arr[left];

        for (i = 0; i < n; ++i) {
            arr[i] = answer[i];
        }
    }
}


