#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
    const int mod = (int)pow(10, 9) + 7;

    int numRollsToTarget(int n, int k, int target) {
        vector<vector<int>> dp(n+1, vector<int>(target+1, -1));
        return helper(dp, n, k, target);
    }

    int helper(vector<vector<int>>& dp, int n, int k, int target) {
        if (target == 0 && n == 0) {
            return 1;
        }
        if (target <= 0 || n == 0) {
            return 0;
        }

        if (dp[n][target] != -1) {
            return dp[n][target] % mod;
        }

        int curr = 0;
        for (int i = 1; i <= k; i++) {
            curr = (curr + helper(dp, n-1, k, target-i)) % mod;
        }
        dp[n][target] = curr % mod;

        return dp[n][target];
    }
};
