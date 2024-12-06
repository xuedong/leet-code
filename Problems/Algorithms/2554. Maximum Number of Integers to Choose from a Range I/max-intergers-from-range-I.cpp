#include <vector>

using namespace std;

class Solution {
private:
    bool binarySearch(vector<int>& arr, int target) {
        int left = -1, right = arr.size();

        while (right - left > 1) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return true;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return false;
    }

public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        sort(banned.begin(), banned.end());

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (binarySearch(banned, i)) continue;

            maxSum -= i;
            if (maxSum < 0) break;

            count++;
        }

        return count;
    }
};
