#include <vector>

using namespace std;

class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        long long total = 0;
        int minVal = INT_MAX;
        int count = 0;

        for (auto& row : matrix) {
            for (int val : row) {
                total += abs(val);
                if (val < 0) {
                    count++;
                }
                minVal = min(minVal, abs(val));
            }
        }

        if (count % 2 != 0) {
            total -= 2 * minVal;
        }

        return total;
    }
};
