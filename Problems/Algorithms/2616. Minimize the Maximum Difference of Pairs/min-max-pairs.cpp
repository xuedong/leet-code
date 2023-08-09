#include <vector>

using namespace std;

class Solution {
public:
    int countPairs(vector<int>& nums, int threshold) {
        int i = 0, count = 0;
        while (i < nums.size() - 1) {
            if (nums[i+1] - nums[i] <= threshold) {
                count++;
                i++;
            }
            i++;
        }

        return count;
    }

    int minimizeMax(vector<int>& nums, int p) {
        int n = nums.size();

        sort(nums.begin(), nums.end());

        int left = -1, right = nums[n-1] - nums[0] + 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (countPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }
};
