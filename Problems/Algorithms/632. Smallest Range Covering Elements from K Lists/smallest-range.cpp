#include <vector>

using namespace std;

class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        int k = nums.size();
        vector<int> indices(k, 0);
        vector<int> range = {0, INT_MAX};

        while (true) {
            int currMin = INT_MAX, currMax = INT_MIN, minListIndex = 0;

            for (int i = 0; i < k; i++) {
                int curr = nums[i][indices[i]];

                if (curr < currMin) {
                    currMin = curr;
                    minListIndex = i;
                }

                if (curr > currMax) {
                    currMax = curr;
                }
            }

            if (currMax - currMin < range[1] - range[0]) {
                range[0] = currMin;
                range[1] = currMax;
            }

            if (++indices[minListIndex] == nums[minListIndex].size()) {
                break;
            }
        }

        return range;
    }
};
