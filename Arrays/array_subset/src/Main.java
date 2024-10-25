//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long[] a1 = new long[(int) (n)];
            long[] a2 = new long[(int) (m)];


            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String[] inputLine1 = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }


            Compute obj = new Compute();
            System.out.println(obj.isSubset(a1, a2, n, m));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    public String isSubset(long[] nums1, long[] nums2, long M, long N) {
        Map<Long, Integer> count = new HashMap<>();

        for (long num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (long num : nums2) {
            count.put(num, count.getOrDefault(num, 0) - 1);
            if (count.get(num) < 0) return "No";
        }

        return "Yes";
    }
}