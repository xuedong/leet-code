#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        int ans = 0;
        int m = requests.size();

        for (int mask = 0; mask < (1 << m); mask++) {
            int setBits = __builtin_popcount(mask);
            if (setBits <= ans) {
                continue;
            }

            vector<int> indegree(n, 0);
            for (int curr = mask, pos = m - 1; curr > 0; curr >>= 1, pos--) {
                if (curr & 1) {
                    indegree[requests[pos][0]]--;
                    indegree[requests[pos][1]]++;
                }
            }

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (indegree[i]) {
                    flag = 0;
                    break;
                }
            }

            if (flag) {
                ans = setBits;
            }
        }

        return ans;
    }
};
