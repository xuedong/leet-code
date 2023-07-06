#include <vector>

using namespace std;

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0, right = 0;
        int curr = 0;
        int ans = INT_MAX;

        for (right = 0; right < nums.size(); right++) {
            curr += nums[right];

            while (curr >= target) {
                ans = min(ans, right - left + 1);
                curr -= nums[left];
                left++;
            }
        }

        return ans == INT_MAX ? 0 : ans;
    }
};
