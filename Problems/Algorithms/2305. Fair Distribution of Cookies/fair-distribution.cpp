#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int dfs(int i, int k, int zeros, vector<int>& distribution, vector<int>& cookies) {
        int n = cookies.size();

        if (n - i < zeros) {
            return INT_MAX;
        }

        if (i == n) {
            return *max_element(distribution.begin(), distribution.end());
        }

        int ans = INT_MAX;
        for (int j = 0; j < k; j++) {
            zeros -= distribution[j] == 0 ? 1 : 0;
            distribution[j] += cookies[i];

            ans = min(ans, dfs(i+1, k, zeros, distribution, cookies));

            distribution[j] -= cookies[i];
            zeros += distribution[j] == 0 ? 1 : 0;
        }

        return ans;
    }

    int distributeCookies(vector<int>& cookies, int k) {
        vector<int> distribution(k, 0);

        return dfs(0, k, k, distribution, cookies);
    }
};
