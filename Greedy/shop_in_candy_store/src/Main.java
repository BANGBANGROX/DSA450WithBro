//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] += nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
            ++left;
            --right;
        }
    }

    private int calcCost(int[] candies, int k) {
        int left = 0;
        int right = candies.length - 1;
        int cost = 0;

        while (left <= right) {
            cost += candies[left];
            right -= k;
            ++left;
        }

        return cost;
    }

    public ArrayList<Integer> candyStore(int[] candies, int n, int k) {
        // code here
        Arrays.sort(candies);

        int minCost = calcCost(candies, k);

        reverse(candies, 0, n - 1);

        int maxCost = calcCost(candies, k);

        return new ArrayList<>(Arrays.asList(minCost, maxCost));
    }
}