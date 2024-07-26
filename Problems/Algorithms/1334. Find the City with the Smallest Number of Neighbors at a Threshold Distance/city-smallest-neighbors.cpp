#include <vector>

using namespace std;

class Solution {
public:
    int n, distanceThreshold;
    int dist[100][100];

    void floydWarshall(vector<vector<int>>& edges) {
        fill(&dist[0][0], &dist[0][0]+100*100, 1e9);
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (auto& edge : edges) {
            int src = edge[0], dst = edge[1], weight = edge[2];
            if (weight <= distanceThreshold) {
                dist[src][dst] = dist[dst][src] = weight;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        this->n = n;
        this->distanceThreshold = distanceThreshold;
        floydWarshall(edges);

        int min_count = n, city = -1;
        for (int i = 0; i < n; i++) {
            int count = -1;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= min_count) {
                min_count = count;
                city = i;
            }
        }

        return city;
    }
};
