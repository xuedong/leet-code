#include <vector>

using namespace std;

class Solution {
private:
    int MOD = 1000000007;
    vector<vector<vector<int>>> memo;

public:
    int helper(int n, int absences, int lates) {
        if (absences >= 2 || lates >= 3) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (memo[n][absences][lates] != -1) {
            return memo[n][absences][lates];
        }

        int count = 0;
        count = helper(n-1, absences, 0);
        count = (count + helper(n-1, absences+1, 0)) % MOD;
        count = (count + helper(n-1, absences, lates+1)) % MOD;

        return memo[n][absences][lates] = count;
    }

    int checkRecord(int n) {
        memo = vector<vector<vector<int>>>(n+1, vector<vector<int>>(2, vector<int>(3, -1)));
        return helper(n, 0, 0);
    }
};