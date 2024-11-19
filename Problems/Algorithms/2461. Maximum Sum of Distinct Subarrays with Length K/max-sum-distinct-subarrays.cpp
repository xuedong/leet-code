#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        long long ans = 0;
        long long curr = 0;

        int begin = 0, end = 0;
        unordered_map<int, int> mapping;
        while (end < nums.size()) {
            int num = nums[end];
            int last = mapping.count(num) ? mapping[num] : -1;

            while (begin <= last || end - begin + 1 > k) {
                curr -= nums[begin];
                begin++;
            }
            mapping[num] = end;
            curr += nums[end];

            if (end - begin + 1 == k) {
                ans = max(ans, curr);
            }
            end++;
        }

        return ans;
    }
};
