//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int zeroCnt = 0;
        int oneCnt = 0;
        int twoCnt = 0;
        int itr = 0;

        for (int num : arr) {
            if (num == 0) ++zeroCnt;
            else if (num == 1) ++oneCnt;
            else if (num == 2) ++twoCnt;
            else throw new RuntimeException("Unexpected value " + num);
        }

        while (zeroCnt > 0) {
            arr[itr] = 0;
            --zeroCnt;
            ++itr;
        }

        while (oneCnt > 0) {
            arr[itr] = 1;
            --oneCnt;
            ++itr;
        }

        while (twoCnt > 0) {
            arr[itr] = 2;
            --twoCnt;
            ++itr;
        }
    }
}