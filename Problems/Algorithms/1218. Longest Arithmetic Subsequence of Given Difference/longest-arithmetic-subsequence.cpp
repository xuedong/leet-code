#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        unordered_map<int, int> dp;
        int ans = 1;

        for (int x : arr) {
            int last = dp.count(x - difference) ? dp[x - difference] : 0;
            dp[x] = last + 1;
            ans = max(ans, dp[x]);
        }

        return ans;
    }
};
