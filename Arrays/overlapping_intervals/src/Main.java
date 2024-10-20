//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] arr = new int[n][2];
            int j = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(s[j]);
                j++;
                arr[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here
        int n = arr.length;
        List<int[]> answer = new LinkedList<>();

        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        answer.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < n; ++i) {
            int[] last = answer.getLast();
            int[] current = arr[i];
            int left = Math.max(last[0], current[0]);
            int right = Math.min(last[1], current[1]);
            if (left <= right) {
                answer.removeLast();
                answer.add(new int[]{Math.min(last[0], current[0]),
                        Math.max(last[1], current[1])});
            } else {
                answer.add(new int[]{current[0], current[1]});
            }
        }

        return answer;
    }
}