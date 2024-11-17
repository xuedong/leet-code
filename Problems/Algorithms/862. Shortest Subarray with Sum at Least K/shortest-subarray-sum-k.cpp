#include <vector>
#include <deque>

using namespace std;

class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        int n = nums.size();

        vector<long long> prefix(n+1, 0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        deque<int> candidates;
        int ans = INT_MAX;
        for (int i = 0; i <= n; i++) {
            while (!candidates.empty() && prefix[i]-prefix[candidates.front()] >= k) {
                ans = min(ans, i-candidates.front());
                candidates.pop_front();
            }

            while (!candidates.empty() && prefix[i] <= prefix[candidates.back()]) {
                candidates.pop_back();
            }
            candidates.push_back(i);
        }

        return ans == INT_MAX ? -1 : ans;
    }
};
