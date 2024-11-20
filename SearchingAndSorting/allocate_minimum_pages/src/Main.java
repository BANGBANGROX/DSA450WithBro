//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    private int[] arr;
    private int k;

    private boolean check(int maxPageCnt) {
        int studentCnt = 1;
        int currentPage = 0;

        for (int page : arr) {
            if (page > maxPageCnt) return false;
            if (currentPage + page > maxPageCnt) {
                ++studentCnt;
                if (studentCnt > k) return false;
                currentPage = page;
            } else {
                currentPage += page;
            }
        }

        return true;
    }

    public int findPages(int[] arr, int k) {
        // code here
        if (k > arr.length) return -1;

        this.arr = arr;
        this.k = k;
        int left = 0;
        int right = Arrays.stream(arr).sum();
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}