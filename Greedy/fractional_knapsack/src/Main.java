//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.printf(
                    "%.6f%n", new Solution().fractionalKnapsack(values, weights, w));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private static class Item {
        int val;
        int wt;

        Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
    }

    // Function to get the maximum total value in the knapsack.
    public double fractionalKnapsack(List<Integer> val, List<Integer> wt,
                                     int capacity) {
        // code here
        ArrayList<Item> items = new ArrayList<>();
        int n = val.size();
        double answer = 0;

        for (int i = 0; i < n; ++i) {
            items.add(new Item(val.get(i), wt.get(i)));
        }

        items.sort((a, b) -> (int) ((long) b.val * a.wt - (long) a.val * b.wt));

        for (int i = 0; i < n; ++i) {
            if (items.get(i).wt <= capacity) {
                answer += items.get(i).val;
                capacity -= items.get(i).wt;
            } else {
                double ratio = 1.0 * items.get(i).val / items.get(i).wt;
                answer += ratio * capacity;
                break;
            }
        }

        return answer;
    }
}