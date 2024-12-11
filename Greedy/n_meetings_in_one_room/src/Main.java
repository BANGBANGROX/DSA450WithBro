//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int[] start, int[] end) {
        // add your code here
        int n = start.length;
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; ++i) {
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int answer = 1;
        int endTime = intervals[0][1];

        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] > endTime) {
                ++answer;
                endTime = intervals[i][1];
            } else {
                endTime = Math.min(endTime, intervals[i][1]);
            }
        }

        return answer;
    }
}
