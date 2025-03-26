#include <vector>

using namespace std;

class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        vector<int> nums;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                nums.push_back(grid[i][j]);
            }
        }

        int n = nums.size();
        nth_element(nums.begin(), nums.begin() + n/2, nums.end());
        int common = nums[n/2];

        int result = 0;
        for (int num : nums) {
            if (num % x != common % x) {
                return -1;
            }

            result += abs(common - num) / x;
        }

        return result;
    }
};
