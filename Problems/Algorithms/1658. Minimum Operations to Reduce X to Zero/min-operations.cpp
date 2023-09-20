#include <vector>

using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        target -= x;

        int n = nums.size();
        if (target == 0) {
            return n;
        }

        int ans = 0;
        int curr = 0, left = 0;
        for (int right = 0; right < n; right++) {
            curr += nums[right];
            while (left <= right && curr > target) {
                curr -= nums[left];
                left++;
            }

            if (curr == target) {
                ans = max(ans, right - left + 1);
            }
        }

        return ans ? n - ans : -1;
    }
};
