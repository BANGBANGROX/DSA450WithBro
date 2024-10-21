//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int minJumps(int[] arr) {
        // code here
        int currentReach = arr[0];
        int maxReach = arr[0];
        int jumps = 1;
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            if (currentReach < i) return -1;
            if (arr[i] > 0) {
                maxReach = Math.max(maxReach, i + arr[i]);
            }
            if (currentReach == i && i != n - 1) {
                ++jumps;
                currentReach = maxReach;
            }
        }

        return jumps;
    }
}