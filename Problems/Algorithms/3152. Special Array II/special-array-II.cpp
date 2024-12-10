#include <vector>

using namespace std;

class Solution {
public:
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) {
        vector<bool> ans(queries.size());
        vector<int> violatingIndices;

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                violatingIndices.push_back(i);
            }
        }

        for (int i = 0; i < queries.size(); i++) {
            vector<int> query = queries[i];
            int start = query[0];
            int end = query[1];

            bool foundViolatingIndex =
                binarySearch(start + 1, end, violatingIndices);

            if (foundViolatingIndex) {
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }

        return ans;
    }

private:
    bool binarySearch(int start, int end, vector<int>& violatingIndices) {
        int left = -1;
        int right = violatingIndices.size();
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            int violatingIndex = violatingIndices[mid];

            if (violatingIndex < start) {
                left = mid;
            } else if (violatingIndex > end) {
                right = mid;
            } else {
                return true;
            }
        }

        return false;
    }
};
