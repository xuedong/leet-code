#include <vector>

using namespace std;

class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int zeros = 0;
        int ans = 0;
        int left = 0;

        for (int i = 0; i < nums.size(); i++) {
            zeros += (nums[i] == 0);

            while (zeros > 1) {
                zeros -= (nums[left] == 0);
                left++;
            }

            ans = max(ans, i - left);
        }

        return ans;
    }
};
