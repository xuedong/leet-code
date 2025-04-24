#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int countCompleteSubarrays(vector<int>& nums) {
        unordered_map<int, int> count;
        unordered_set<int> set(nums.begin(), nums.end());
        int distinct_count = set.size();
        
        int n = nums.size();
        int right = 0;
        int ans = 0;
        for (int left = 0; left < n; left++) {
            if (left > 0) {
                int remove = nums[left-1];
                count[remove]--;
                if (count[remove] == 0) {
                    count.erase(remove);
                }
            }

            while (right < n && count.size() < distinct_count) {
                int add = nums[right];
                count[add]++;
                right++;
            }

            if (count.size() == distinct_count) {
                ans += (n - right + 1);
            }
        }

        return ans;
    }
};
