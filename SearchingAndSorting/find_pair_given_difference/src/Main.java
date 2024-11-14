//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String[] inputLine = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int x;
            x = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            boolean res = obj.findPair(arr, x);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        Set<Integer> visited = new HashSet<>();

        for (int num : arr) {
            if (visited.contains(num - x) || visited.contains(num + x)) return true;
            visited.add(num);
        }

        return false;
    }
}
