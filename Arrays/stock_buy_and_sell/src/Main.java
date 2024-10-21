//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] A = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int p = 0;
            for (int i = 0; i < n - 1; i++)
                p += Math.max(0, A[i + 1] - A[i]);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.stockBuySell(A, n);
            if (ans.isEmpty())
                System.out.print("No Profit");
            else {
                int c = 0;
                for (ArrayList<Integer> an : ans) c += A[an.get(1)] - A[an.get(0)];

                if (c == p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    public ArrayList<ArrayList<Integer> > stockBuySell(int[] prices, int n) {
        // code here
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 1; i < n; ++i) {
            if (prices[i] > prices[i - 1]) {
                answer.add(new ArrayList<>(Arrays.asList(i - 1, i)));
            }
        }

        return answer;
    }
}
