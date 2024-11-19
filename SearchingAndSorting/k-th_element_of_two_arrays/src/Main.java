//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int[] arr1, int[] arr2) {
        // code here
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            int num;
            if (arr1[i] <= arr2[j]) {
                num = arr1[i];
                ++i;
            } else {
                num = arr2[j];
                ++j;
            }
            --k;
            if (k == 0) return num;
        }

        while (i < m) {
            --k;
            if (k == 0) return arr1[i];
            ++i;
        }

        while (j < n) {
            --k;
            if (k == 0) return arr2[j];
            ++j;
        }

        return -1;
    }
}