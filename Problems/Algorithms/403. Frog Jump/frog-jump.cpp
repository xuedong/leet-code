#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    unordered_map<int, int> mark;
    int dp[2001][2001];

    int helper(vector<int>& stones, int n, int i, int prev) {
        if (i == n-1) {
            return 1;
        }

        if (dp[i][prev] != -1) {
            return dp[i][prev];
        }

        int ans = false;
        for (int next = prev-1; next <= prev+1; next++) {
            if (next > 0 && mark.find(stones[i] + next) != mark.end()) {
                ans = ans || helper(stones, n, mark[stones[i] + next], next);
            }
        }

        return dp[i][prev] = ans;
    }

    bool canCross(vector<int>& stones) {
        int n = stones.size();

        for (int i = 0; i < n; i++) {
            mark.insert({stones[i], i});
        }

        memset(dp, -1, sizeof(dp));
        return helper(stones, n, 0, 0);
    }
};
