#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int k) {
        if (n < 2) {
            return 1;
        }

        unordered_map<int, unordered_set<int>> graph;
        for (const auto& edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            graph[node1].insert(node2);
            graph[node2].insert(node1);
        }

        queue<int> queue;
        for (const auto& [node, neighbors] : graph) {
            if (neighbors.size() == 1) {
                queue.push(node);
            }
        }

        vector<long long> llValues(values.begin(), values.end());
        int count = 0;
        while (!queue.empty()) {
            int curr = queue.front();
            queue.pop();

            int neighbor = -1;
            if (!graph[curr].empty()) {
                neighbor = *graph[curr].begin();
            }

            if (neighbor >= 0) {
                graph[neighbor].erase(curr);
                graph[curr].erase(neighbor);
            }

            if (llValues[curr] % k == 0) {
                count++;
            } else if (neighbor >= 0) {
                llValues[neighbor] += llValues[curr];
            }

            if (neighbor >= 0 && graph[neighbor].size() == 1) {
                queue.push(neighbor);
            }
        }

        return count;
    }
};
