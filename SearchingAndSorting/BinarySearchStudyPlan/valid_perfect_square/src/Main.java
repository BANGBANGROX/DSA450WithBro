import java.util.Scanner;

class Solution {
    public boolean isPerfectSquare(int num) {
        double squareRoot = Math.sqrt(num);

        return squareRoot == Math.floor(squareRoot);
    }
}


public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().isPerfectSquare(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
