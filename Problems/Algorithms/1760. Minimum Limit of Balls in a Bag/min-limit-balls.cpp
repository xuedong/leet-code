#include <vector>
#include <cmath>

using namespace std;

class Solution {
private:
    bool isPossible(int maxBalls, vector<int>& nums, int maxOperations) {
        int totalOperations = 0;

        for (int num : nums) {
            int operations = ceil(num / (double)maxBalls) - 1;
            totalOperations += operations;

            if (totalOperations > maxOperations) return false;
        }

        return true;
    }

public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        int left = 0;
        int right = 0;
        for (auto num : nums) {
            right = max(right, num);
        }
        right += 1;

        while (right - left > 1) {
            int mid = left + (right - left) / 2;

            if (isPossible(mid, nums, maxOperations)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }
};
