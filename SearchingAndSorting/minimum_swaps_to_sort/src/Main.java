//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


// } Driver Code Ends


class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int[] arr) {
        // Code here
        int n = arr.length;
        int answer = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> numAndIndexes = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            numAndIndexes.add(List.of(arr[i], i));
        }

        numAndIndexes.sort(Comparator.comparingInt(List::getFirst));

        for (int i = 0; i < n; ++i) {
            if (visited[i] || numAndIndexes.get(i).get(1) == i) continue;
            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = numAndIndexes.get(j).get(1);
                ++cycleSize;
            }
            answer += (cycleSize - 1);
        }

        return answer;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            int ans = obj.minSwaps(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends