#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <queue>

using namespace std;

class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        unordered_map<int, vector<int>> adj;
        for (int route = 0; route < routes.size(); route++) {
            for (auto stop : routes[route]) {
                adj[stop].push_back(route);
            }
        }

        queue<int> queue;
        unordered_set<int> visited;
        for (auto route : adj[source]) {
            queue.push(route);
            visited.insert(route);
        }

        int count = 1;
        while (queue.size()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int route = queue.front();
                queue.pop();

                for (auto stop : routes[route]) {
                    if (stop == target) {
                        return count;
                    }

                    for (auto next : adj[stop]) {
                        if (!visited.count(next)) {
                            visited.insert(next);
                            queue.push(next);
                        }
                    }
                }
            }

            count++;
        }

        return -1;
    }
};
