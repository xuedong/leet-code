#include <vector>

using namespace std;

class Solution {
public:
    int findChampion(int n, vector<vector<int>>& edges) {
        vector<int> indegree(n, 0);
        for (auto edge : edges) {
            indegree[edge[1]]++;
        }

        int champion = -1, count = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                count++;
                champion = i;
            }
        }

        return count > 1 ? -1 : champion;
    }
};
