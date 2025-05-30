#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    void bfs(int startNode, vector<int>& edges, vector<int>& dist) {
        int n = edges.size();
        queue<int> q;
        q.push(startNode);

        vector<bool> visit(n);
        dist[startNode] = 0;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            if (visit[node]) {
                continue;
            }

            visit[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1 && !visit[neighbor]) {
                dist[neighbor] = 1 + dist[node];
                q.push(neighbor);
            }
        }
    }

    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        int n = edges.size();
        vector<int> dist1(n, numeric_limits<int>::max());
        vector<int> dist2(n, numeric_limits<int>::max());

        bfs(node1, edges, dist1);
        bfs(node2, edges, dist2);

        int ans = -1, curr = numeric_limits<int>::max();
        for (int currNode = 0; currNode < n; currNode++) {
            if (curr > max(dist1[currNode], dist2[currNode])) {
                ans = currNode;
                curr = max(dist1[currNode], dist2[currNode]);
            }
        }

        return ans;
    }
};
