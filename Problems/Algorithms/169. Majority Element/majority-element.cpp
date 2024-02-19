#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map<int, int> counts;
        int n = nums.size() / 2;
        for (auto num : nums) {
            counts[num]++;
        }

        int ans = 0;
        for (auto num : counts) {
            if (num.second > n) {
                ans = num.first;
            }
        }

        return ans;
    }
};
