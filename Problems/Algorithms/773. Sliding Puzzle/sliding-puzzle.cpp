#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

class Solution {
private:
    vector<vector<int>> directions = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 5, 1}, {4, 2}};

    void dfs(string state, unordered_map<string, int>& visited, int zero, int moves) {
        if (visited.count(state) && visited[state] <= moves) {
            return;
        }
        visited[state] = moves;

        for (int next : directions[zero]) {
            swap(state[zero], state[next]);
            dfs(state, visited, next, moves+1);
            swap(state[zero], state[next]);
        }
    }

public:
    int slidingPuzzle(vector<vector<int>>& board) {
        string start;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += to_string(board[i][j]);
            }
        }

        unordered_map<string, int> visited;
        dfs(start, visited, start.find('0'), 0);

        return visited.count("123450") ? visited["123450"] : -1;
    }
};
