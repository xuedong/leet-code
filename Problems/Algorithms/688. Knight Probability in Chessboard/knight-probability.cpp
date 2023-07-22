#include <vector>

using namespace std;

class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        vector<pair<int, int>> directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        vector dp(k+1, vector(n, vector<double>(n, 0.0)));
        dp[0][row][column] = 1;

        for (int moves = 1; moves <= k; moves++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (const auto& direction : directions) {
                        int prevI = i - direction.first;
                        int prevJ = j - direction.second;

                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            dp[moves][i][j] += dp[moves-1][prevI][prevJ] / 8;
                        }
                    }
                }
            }
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[k][i][j];
            }
        }

        return ans;
    }
};
