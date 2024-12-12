//{ Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> d = new ArrayList<>();

            for (int i = 0; i < p; i++) {
                a.add(sc.nextInt());
                b.add(sc.nextInt());
                d.add(sc.nextInt());
            }

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.solve(n, p, a, b, d);
            System.out.println(ans.size());
            for (ArrayList<Integer> an : ans) {
                System.out.println(an.get(0) + " " + an.get(1) + " " + an.get(2));
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private int[] outgoing;
    private int[] weights;
    private boolean[] visited;
    private int minWeight;

    private int find(int node) {
        visited[node] = true;

        if (outgoing[node] == 0) return node;

        minWeight = Math.min(minWeight, weights[node]);

        return find(outgoing[node]);
    }

    public ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a,
                                               ArrayList<Integer> b ,ArrayList<Integer> d) {
        // code here
        outgoing = new int[n + 1];
        weights = new int[n + 1];
        visited = new boolean[n + 1];
        int[] incoming = new int[n + 1];
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < p; ++i) {
            outgoing[a.get(i)] = b.get(i);
            incoming[b.get(i)] = a.get(i);
            weights[a.get(i)] = d.get(i);
        }

        for (int i = 1; i <= n; ++i) {
            if (!visited[i] && incoming[i] == 0) {
                minWeight = Integer.MAX_VALUE;
                int endpoint = find(i);
                if (i == endpoint) continue;
                answer.add(new ArrayList<>(Arrays.asList(i, endpoint, minWeight)));
            }
        }

        return answer;
    }
}