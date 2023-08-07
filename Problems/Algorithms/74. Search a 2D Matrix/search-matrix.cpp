#include <vector>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size(), m = matrix[0].size();
        int left = -1, right = n * m;

        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            int x = mid / m, y = mid % m;
            int curr = matrix[x][y];

            if (curr > target) {
                right = mid;
            } else if (curr < target) {
                left = mid;
            } else {
                return true;
            }
        }

        return false;
    }
};
