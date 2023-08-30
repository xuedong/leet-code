#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        long long ans = 0;
        int n = nums.size();

        for (int i = n-2; i >= 0; i--) {
            if (nums[i] <= nums[i+1]) {
                continue;
            }

            long long count = ceil((nums[i] + nums[i+1] - 1LL) / nums[i+1]);
            ans += count - 1;

            nums[i] = nums[i] / count;
        }

        return ans;
    }
};
