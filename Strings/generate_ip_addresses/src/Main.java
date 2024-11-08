//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.isEmpty())
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    private ArrayList<String> answer;
    private String s;
    private int n;

    private void genIpHandler(int idx, String currentIp, int sections) {
        if (sections > 4) return;

        if (idx >= n) {
            if (sections == 4) {
                answer.add(currentIp);
            }
            return;
        }

        if (s.charAt(idx) == '0') {
            String nextIp = (currentIp.isEmpty() ? "0" : currentIp + "." +
                    '0');
            genIpHandler(idx + 1, nextIp, sections + 1);
            return;
        }

        String currentNumber = "";

        for (int i = idx; i < n; ++i) {
            currentNumber += s.charAt(i);
            int number = Integer.parseInt(currentNumber);
            if (number > 0 && number <= 255) {
                String nextIp = (currentIp.isEmpty() ? currentNumber : currentIp + "." +
                        currentNumber);
                genIpHandler(i + 1, nextIp, sections + 1);
            } else if (number > 255) break;
        }
    }

    public ArrayList<String> genIp(String s) {
        // code here
        answer = new ArrayList<>();
        this.s = s;
        n = s.length();

        genIpHandler(0, "", 0);

        return answer;
    }
}