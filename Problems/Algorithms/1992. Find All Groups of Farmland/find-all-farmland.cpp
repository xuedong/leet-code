#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        int m = land.size(), n = land[0].size();
        vector<vector<int>> ans;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (land[row][col]) {
                    int x = row, y = col;

                    for (x = row; x < m && land[x][col]; x++) {
                        for (y = col; y < n && land[x][y]; y++) {
                            land[x][y] = 0;
                        }
                    }

                    ans.push_back({row, col, x-1, y-1});
                }
            }
        }

        return ans;
    }
};
