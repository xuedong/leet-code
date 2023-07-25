#include <vector>

using namespace std;

class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int left = -1, right = arr.size();
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid+1]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }
};
