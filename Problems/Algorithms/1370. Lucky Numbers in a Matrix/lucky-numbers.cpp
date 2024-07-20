#include <vector>

using namespace std;

class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        int n = matrix.size(), m = matrix[0].size();
        
        int rowMinMax = INT_MIN;
        for (int i = 0; i < n; i++) {

            int rowMin = INT_MAX;
            for (int j = 0; j < m; j++) {
                rowMin = min(rowMin, matrix[i][j]);
            }
            rowMinMax = max(rowMinMax, rowMin);
        }
        
        int colMaxMin = INT_MAX;
        for (int i = 0; i < m; i++) {

            int colMax = INT_MIN;
            for (int j = 0; j < n; j++) {
                colMax = max(colMax, matrix[j][i]);
            }
            colMaxMin = min(colMaxMin, colMax);
        }
        
        if (rowMinMax == colMaxMin) {
            return {rowMinMax};
        }
        
        return {};
    }
};
