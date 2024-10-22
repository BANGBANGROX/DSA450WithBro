//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class IntMatrix {
    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

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

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.getPairs(arr);
            if (res.isEmpty()) {
                System.out.println();
            } else {
                IntMatrix.print(res);
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        Set<ArrayList<Integer>> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        Arrays.sort(arr);

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == 0) {
                ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
                if (!visited.contains(pair)) {
                    answer.add(pair);
                    visited.add(pair);
                }
                ++left;
                --right;
            } else if (currentSum > 0) {
                --right;
            } else {
                ++left;
            }
        }

        return answer;
    }
}
