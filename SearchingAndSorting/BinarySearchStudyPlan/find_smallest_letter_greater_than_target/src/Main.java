import java.util.Scanner;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        char answer = letters[0];

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (letters[mid] > target) {
                answer = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           char[] letters = new char[n];
           for (int i = 0; i < n; ++i) {
               letters[i] = scanner.next().charAt(0);
           }
           char target = scanner.next().charAt(0);

           System.out.println(new Solution().nextGreatestLetter(letters, target));
       }
       
       scanner.close();
   }
}
