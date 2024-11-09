//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    private String getKey(int[] count) {
        StringBuilder key = new StringBuilder();

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (count[ch - 'a'] > 0) {
                key.append(ch).append(count[ch - 'a']);
            }
        }

        return key.toString();
    }

    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        Map<String, List<String>> anagramsMap = new HashMap<>();
        ArrayList<ArrayList<String>> answer = new ArrayList<>();

        for (String s : arr) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                ++count[ch - 'a'];
            }
            String key = getKey(count);
            anagramsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        for (Map.Entry<String, List<String>> entry : anagramsMap.entrySet()) {
            answer.add(new ArrayList<>(entry.getValue()));
        }

        answer.sort((a, b) -> {
            for (String s1 : a) {
                for (String s2 : b) {
                    if (s1.compareTo(s2) < 0) return -1;
                }
            }

            return 1;
        });

        return answer;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(ArrayList::getFirst));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends