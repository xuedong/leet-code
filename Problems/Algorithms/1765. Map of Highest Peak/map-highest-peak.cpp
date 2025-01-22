#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        int directions[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int rows = isWater.size();
        int cols = isWater[0].size();

        vector<vector<int>> heights(rows, vector<int>(cols, -1));
        queue<pair<int, int>> queue;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isWater[row][col]) {
                    queue.push({row, col});
                    heights[row][col] = 0;
                }
            }
        }

        int nextHeight = 1;
        while (!queue.empty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                pair<int, int> curr = queue.front();
                queue.pop();

                for (int direction = 0; direction < 4; direction++) {
                    pair<int, int> neighbor = {curr.first + directions[direction][0], curr.second + directions[direction][1]};

                    if (neighbor.first >= 0 && neighbor.second >= 0 && neighbor.first < rows && neighbor.second < cols && heights[neighbor.first][neighbor.second] == -1) {
                        heights[neighbor.first][neighbor.second] = nextHeight;
                        queue.push(neighbor);
                    }
                }
            }

            nextHeight++;
        }

        return heights;
    }
};
