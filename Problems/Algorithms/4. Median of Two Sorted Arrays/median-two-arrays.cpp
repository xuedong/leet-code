#include <vector>

using namespace std;

class Solution {
public:
    int pointer1 = 0, pointer2 = 0;

    int getMin(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();

        if (pointer1 < m && pointer2 < n) {
            return nums1[pointer1] < nums2[pointer2] ? nums1[pointer1++] : nums2[pointer2++];
        } else if (pointer1 < m) {
            return nums1[pointer1++];
        } else if (pointer2 < n) {
            return nums2[pointer2++];
        }

        return -1;
    }

    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();

        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                int _ = getMin(nums1, nums2);
            }
            return (double)(getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < (m + n) / 2; ++i) {
                int _ = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
            
        return -1;
    }
};
