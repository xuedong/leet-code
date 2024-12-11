#include <vector>

using namespace std;

class Solution {
public:
    int maximumBeauty(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());

        int maxBeauty = 0;
        for (int i = 0; i < nums.size(); i++) {
            int upper = find(nums, nums[i] + 2 * k);
            maxBeauty = max(maxBeauty, upper - i + 1);
        }
        return maxBeauty;
    }

private:
    int find(vector<int>& arr, int val) {
        int low = -1, high = arr.size();
        
        int result = 0;

        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                result = mid;
                low = mid;
            } else {
                high = mid;
            }
        }
        return result;
    }
};
