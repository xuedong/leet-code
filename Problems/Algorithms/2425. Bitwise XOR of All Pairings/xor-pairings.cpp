#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();

        unordered_map<int, long> freq;
        for (int num : nums1) {
            freq[num] += n2;
        }
        for (int num : nums2) {
            freq[num] += n1;
        }

        int ans = 0;
        for (auto& [num, count] : freq) {
            if (count % 2 == 1) {
                ans ^= num;
            }
        }

        return ans;
    }
};
