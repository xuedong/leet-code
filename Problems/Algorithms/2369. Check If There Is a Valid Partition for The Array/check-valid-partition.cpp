#include <vector>

using namespace std;

class Solution {
public:
    bool helper(vector<int>& nums, vector<int>& dp, int i) {
        int n = nums.size();

        if (i == n) {
            return true;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        if (i + 1 < n && nums[i] == nums[i+1]) {
            if (helper(nums, dp, i+2)) {
                return true;
            }
        }

        if (i + 2 < n && nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) {
            if (helper(nums, dp, i+3)) {
                return true;
            }
        }

        if (i + 2 < n && nums[i] + 1 == nums[i+1] && nums[i+1] + 1 == nums[i+2]) {
            if (helper(nums, dp, i+3)) {
                return true;
            }
        }

        return dp[i] = false;
    }

    bool validPartition(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1, -1);
        
        return helper(nums, dp, 0);
    }
};
