#include <vector>

using namespace std;

class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        long count = 0;
        long start = -1;
        long minId = -1, maxId = -1;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                start = i;
            }

            if (nums[i] == maxK) {
                maxId = i;
            }
            if (nums[i] == minK) {
                minId = i;
            }

            count += max(0L, min(minId, maxId) - start);
        }

        return count;
    }
};
