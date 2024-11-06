//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S = br.readLine().trim();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for (int[] an : ans) {
                for (int i : an) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            if (ans.length == 0) {
                System.out.println("-1");
            }


            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1},
            {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
    private String word;
    private char[][] grid;
    private int m;
    private int n;

    private boolean search(int i, int j, int dir) {
        for (char ch : word.toCharArray()) {
            if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != ch) return false;
            i += directions[dir][0];
            j += directions[dir][1];
        }

        return true;
    }

    public int[][] searchWord(char[][] grid, String word) {
        // Code here
        List<int[]> answer = new ArrayList<>();
        this.grid = grid;
        this.word = word;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int dir = 0; dir < 8; ++dir) {
                        if (search(i, j, dir)) {
                            answer.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }

        int[][] finalAnswer = new int[answer.size()][2];

        for (int i = 0; i < answer.size(); ++i) {
            finalAnswer[i] = answer.get(i);
        }

        return finalAnswer;
    }
}