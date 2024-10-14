#include <vector>
#include <queue>
#include <math.h>

using namespace std;

class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for (auto& num : nums) {
            pq.push(num);
        }

        long long int ans = 0;
        while (k--) {
            int max = pq.top();
            ans += max;
            pq.pop();
            pq.push(ceil(max / 3.0));
        }

        return ans;
    }
};
