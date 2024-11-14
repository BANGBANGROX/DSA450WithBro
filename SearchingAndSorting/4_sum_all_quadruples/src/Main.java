//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            // String[] nk = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(nk[0]);
            // int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.println();
            }
            if (ans.isEmpty()) {
                System.out.println(-1);
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Set<ArrayList<Integer>> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                int requiredSum = k - arr[i] - arr[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int currentSum = arr[left] + arr[right];
                    if (currentSum == requiredSum) {
                        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr[i], arr[j],
                                arr[left], arr[right]));
                        if (!visited.contains(list)) {
                            answer.add(new ArrayList<>(list));
                            visited.add(new ArrayList<>(list));
                        }
                        ++left;
                        --right;
                    } else if (currentSum > requiredSum) {
                        --right;
                    } else {
                        ++left;
                    }
                }
            }
        }

        return answer;
    }
}