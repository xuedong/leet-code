#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int maxLength(vector<string>& arr) {
        vector<int> dp = {0};

        int ans = 0;
        for (const string& str : arr) {
            int curr = 0, dup = 0;
            for (char ch : str) {
                dup |= curr & (1 << (ch - 'a'));
                curr |= 1 << (ch - 'a');
            }

            if (dup > 0) {
                continue;
            }

            for (int i = dp.size()-1; i >= 0; i--) {
                if ((dp[i] & curr) > 0) {
                    continue;
                }

                dp.push_back(dp[i] | curr);
                ans = max(ans, __builtin_popcount(dp[i] | curr));
            }
        }

        return ans;
    }
};
