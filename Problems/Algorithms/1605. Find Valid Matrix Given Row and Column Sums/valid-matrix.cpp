#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int n = rowSum.size();
        int m = colSum.size();

        vector<int> currRowSum(n, 0);
        vector<int> currColSum(m, 0);

        vector<vector<int>> mat(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = min(rowSum[i] - currRowSum[i], colSum[j] - currColSum[j]);
                
                currRowSum[i] += mat[i][j];
                currColSum[j] += mat[i][j];
            }
        }

        return mat;
    }
};
