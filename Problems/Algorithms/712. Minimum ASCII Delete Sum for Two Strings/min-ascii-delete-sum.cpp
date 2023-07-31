#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    long long aux(int i, int j, string& s1, string& s2, vector<vector<int>>& dp) {
        int n1 = s1.size();
        int n2 = s2.size();

        if (i == n1 && j == n2) {
            return 0;
        }

        if (i == n1) {
            int total = 0;
            for (int k = j; k < n2; k++) {
                total += (int)s2[k];
            }
            return total;
        }

        if (j == n2) {
            int total = 0;
            for (int k = i; k < n1; k++) {
                total += (int)s1[k];
            }
            return total;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long long ans = INT_MAX;
        if (s1[i] == s2[j]) {
            ans = aux(i+1, j+1, s1, s2, dp);
        } else {
            ans = min(ans, s1[i] + aux(i+1, j, s1, s2, dp));
            ans = min(ans, s2[j] + aux(i, j+1, s1, s2, dp));
        }

        return dp[i][j] = ans;
    }

    int minimumDeleteSum(string s1, string s2) {
        vector<vector<int>> dp(s1.size(), vector<int>(s2.size(), -1));

        return aux(0, 0, s1, s2, dp);
    }
};
