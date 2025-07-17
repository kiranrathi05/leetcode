class Solution {
    public int maximumLength(int[] nums, int k) {
        // dp[i][j] stores the maximum length of a subsequence ending with remainders i and j.
        // Essentially, if we have numbers with remainders 'i' and 'j', this stores the longest
        // subsequence we can build ending with them.
        int[][] dp = new int[k][k]; 

        int ans = 0; // This will store the final answer - the maximum length found.

        // We go through each number in the input array 'nums'
        for (int n : nums) {
            // Calculate the remainder of the current number when divided by k.
            int x = n % k; 

            // Now, we iterate through all possible remainders 'y' (from 0 to k-1)
            for (int y = 0; y < k; y++) {
                // This is the core logic:
                //  - dp[x][y] = dp[y][x] + 1; 
                //    We're saying: "If we had a subsequence ending with remainders 'y' and 'x',
                //     and now we encounter a number with remainder 'x', we can extend that subsequence
                //     by adding this new number." We add 1 to the length of the subsequence.
                //  - The reason we look at dp[y][x] instead of dp[x][x] is a bit tricky. It means that, to form a valid sequence
                //    we require the last two numbers have the same mod k.
                dp[x][y] = dp[y][x] + 1; 
/*❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗
dp[x][y] is needed in order to keep track of which combinations
 of the last two residues we already have in the 
constructed sequences. This prevents us from adding 
the same numbers endlessly, without considering that 
we need a sequence where the sum of neighboring 
elements gives a constant remainder.*/

                // Update the overall maximum length 'ans' if the current subsequence is longer.
                ans = Math.max(ans, dp[x][y]);
            }
        }

        // Finally, return the maximum length found.
        return ans;
    }
}