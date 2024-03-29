#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        
        vector<int> indegree(n);
        vector<vector<int>> adj(n);
        for (int i = 0; i < n; i++) {
            for (auto node : graph[i]) {
                adj[node].push_back(i);
                indegree[i]++;
            }
        }

        queue<int> queue;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.push(i);
            }
        }

        vector<bool> safe(n);
        while (!queue.empty()) {
            int node = queue.front();
            queue.pop();
            safe[node] = true;

            for (auto& neighbor : adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.push(neighbor);
                }
            }
        }

        vector<int> ans;
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.push_back(i);
            }
        }

        return ans;
    }
};
