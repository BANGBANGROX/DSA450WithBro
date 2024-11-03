import java.util.Scanner;

class Solution {
    public int nextGreaterElement(int n) {
        char[] numArray = String.valueOf(n).toCharArray();
        int len = numArray.length;
        int last = len - 2;

        while (last >= 0 && numArray[last + 1] <= numArray[last]) {
            --last;
        }

        if (last < 0) return -1;

        int idx = last + 1;

        for (int i = last + 2; i < len; ++i) {
            if (numArray[i] > numArray[last] && numArray[i] <= numArray[idx]) {
                idx = i;
            }
        }

        char temp = numArray[last];
        numArray[last] = numArray[idx];
        numArray[idx] = temp;

        int left = last + 1;
        int right = len - 1;

        while (left < right) {
            char temp2 = numArray[left];
            numArray[left] = numArray[right];
            numArray[right] = temp2;
            ++left;
            --right;
        }

        long answer = Long.parseLong(new String(numArray));

        return answer <= Integer.MAX_VALUE ? (int) answer : -1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().nextGreaterElement(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
