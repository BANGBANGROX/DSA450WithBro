//{ Driver Code Starts
//Initial Template for Java


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
            int[] f = new int[N];
            for (int i = 0; i < N; i++) {
                f[i] = Integer.parseInt(element[i]);
            }
            ArrayList<String> res = ob.huffmanCodes(S, f, N);
            for (String re : res) {
                System.out.print(re + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    private ArrayList<String> answer;

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void traverse(Node node, String current) {
        if (node.left == null) {
            answer.add(current);
        } else {
            traverse(node.left, current + '0');
            traverse(node.right, current + '1');
        }
    }

    public ArrayList<String> huffmanCodes(String S, int[] f, int n) {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val != b.val ?
                a.val - b.val : 1);
        answer = new ArrayList<>();

        for (int val : f) {
            pq.add(new Node(val, null, null));
        }

        while (pq.size() > 1) {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            pq.add(new Node(n1.val + n2.val, n1, n2));
        }

        traverse(pq.poll(), "");

        return answer;
    }
}