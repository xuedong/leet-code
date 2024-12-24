#include <vector>
#include <queue>
#include <cmath>

using namespace std;

class Solution {
public:
    int minimumDiameterAfterMerge(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        int n = edges1.size() + 1;
        int m = edges2.size() + 1;

        vector<vector<int>> adj1 = build(n, edges1);
        vector<vector<int>> adj2 = build(m, edges2);

        int diameter1 = diameter(n, adj1);
        int diameter2 = diameter(m, adj2);

        int combined = ceil(diameter1 / 2.0) + ceil(diameter2 / 2.0) + 1;
        return max({diameter1, diameter2, combined});
    }

private:
    vector<vector<int>> build(int size, vector<vector<int>>& edges) {
        vector<vector<int>> adj(size);

        for (auto edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        return adj;
    }

    int diameter(int size, vector<vector<int>>& adj) {
        auto [farthest, _] = find(size, adj, 0);
        auto [_, diameter] = find(size, adj, farthest);
        return diameter;
    }

    pair<int, int> find(int size, vector<vector<int>>& adj, int source) {
        queue<int> queue;
        queue.push(source);

        vector<bool> visited(size, false);
        visited[source] = true;

        int maxDist = 0, farthest = source;
        while (!queue.empty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int curr = queue.front();
                queue.pop();

                farthest = curr;
                for (int neighbor : adj[curr]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.push(neighbor);
                    }
                }
            }

            if (!queue.empty()) {
                maxDist++;
            }
        }

        return {farthest, maxDist};
    }
};
