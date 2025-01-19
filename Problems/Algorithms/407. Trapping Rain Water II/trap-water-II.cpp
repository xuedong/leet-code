#include <queue>
#include <vector>

using namespace std;

class Cell {
    public:
        int height;
        int row;
        int col;

        Cell(int height, int row, int col) {
            this->height = height;
            this->row = row;
            this->col = col;
        }

        bool operator<(const Cell& other) const {
            return height >= other.height;
        }
};

class Solution {
private:
    bool isValid(int row, int col, int rows, int cols) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }

public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        int directions[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int rows = heightMap.size(), cols = heightMap[0].size();

        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        priority_queue<Cell> boundary;

        for (int i = 0; i < rows; i++) {
            boundary.push(Cell(heightMap[i][0], i, 0));
            boundary.push(Cell(heightMap[i][cols-1], i, cols-1));
            visited[i][0] = visited[i][cols-1] = true;
        }

        for (int j = 0; j < cols; j++) {
            boundary.push(Cell(heightMap[0][j], 0, j));
            boundary.push(Cell(heightMap[rows-1][j], rows-1, j));
            visited[0][j] = visited[rows-1][j] = true;
        }

        int volume = 0;
        while (!boundary.empty()) {
            Cell curr = boundary.top();
            boundary.pop();

            int row = curr.row;
            int col = curr.col;
            int height = curr.height;

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + directions[direction][0];
                int nextCol = col + directions[direction][1];

                if (isValid(nextRow, nextCol, rows, cols) && !visited[nextRow][nextCol]) {
                    int nextHeight = heightMap[nextRow][nextCol];

                    if (nextHeight < height) {
                        volume += height - nextHeight;
                    }

                    boundary.push(Cell(max(nextHeight, height), nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return volume;
    }
};
