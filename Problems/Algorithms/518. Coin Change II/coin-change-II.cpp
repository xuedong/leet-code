#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> dp;

    int count(int i, int amount, vector<int>& coins) {
        if (amount == 0) {
            return 1;
        }

        if (i == coins.size()) {
            return 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        if (coins[i] > amount) {
            return dp[i][amount] = count(i+1, amount, coins);
        }

        dp[i][amount] = count(i, amount-coins[i], coins) + count(i+1, amount, coins);
        return dp[i][amount];
    }

    int change(int amount, vector<int>& coins) {
        dp = vector<vector<int>>(coins.size(), vector<int>(amount+1, -1));
        
        return count(0, amount, coins);
    }
};
