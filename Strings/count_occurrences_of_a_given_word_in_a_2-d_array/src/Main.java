//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t > 0) {
            int R = sc.nextInt();
            int C = sc.nextInt();

            char[][] mat = new char[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat, target));

            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private char[][] mat;
    private String target;
    private int m;
    private int n;
    private int answer;

    private void findOccurrenceHandler(int x, int y, int idx) {
        if (x < 0 || x >= m || y < 0 || y >= n || mat[x][y] != target.charAt(idx)) return;

        if (idx == target.length() - 1) {
            ++answer;
            return;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean result = false;
        mat[x][y] = '#';

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            findOccurrenceHandler(newX, newY, idx + 1);
        }

        mat[x][y] = target.charAt(idx);
    }

    public int findOccurrence(char[][] mat, String target) {
        // Write your code here
        answer = 0;
        this.mat = mat;
        this.target = target;
        m = mat.length;
        n = mat[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                findOccurrenceHandler(i, j, 0);
            }
        }

        return answer;
    }
}