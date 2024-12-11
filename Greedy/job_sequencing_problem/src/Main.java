//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDs = sc.nextLine().split(" ");
            String[] deadlines = sc.nextLine().split(" ");
            String[] profits = sc.nextLine().split(" ");

            int n = jobIDs.length;
            Job[] jobs = new Job[n];

            for (int i = 0; i < n; i++) {
                int id = Integer.parseInt(jobIDs[i]);
                int deadline = Integer.parseInt(deadlines[i]);
                int profit = Integer.parseInt(profits[i]);
                jobs[i] = new Job(id, deadline, profit);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobScheduling(jobs, n);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
*/

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    public ArrayList<Integer> JobScheduling(Job[] jobs, int n) {
        // Your code here
        boolean[] days = new boolean[n + 1];
        int totalJobs = 0;
        int totalProfit = 0;

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        for (int i = 0; i < n; ++i) {
            while (jobs[i].deadline > 0 && days[jobs[i].deadline]) {
                --jobs[i].deadline;
            }
            if (jobs[i].deadline > 0) {
                days[jobs[i].deadline] = true;
                ++totalJobs;
                totalProfit += jobs[i].profit;
            }
        }

        return new ArrayList<>(Arrays.asList(totalJobs, totalProfit));
    }
}
