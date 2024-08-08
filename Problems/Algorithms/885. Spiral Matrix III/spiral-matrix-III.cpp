#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        vector<vector<int>> directions{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        vector<vector<int>> visited;

        for (int step = 1, direction = 0; visited.size() < rows * cols;) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        visited.push_back({rStart, cStart});
                    }

                    rStart += directions[direction][0];
                    cStart += directions[direction][1];
                }

                direction = (direction + 1) % 4;
            }

            step++;
        }

        return visited;
    }
};
