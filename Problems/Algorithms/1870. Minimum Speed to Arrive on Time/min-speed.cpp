#include <vector>

using namespace std;

class Solution {
public:
    double computeTime(vector<int>& dist, int speed) {
        double time = 0.0;
        int n = dist.size();
        for (int i = 0; i < dist.size(); i++) {
            double curr = (double) dist[i] / (double) speed;
            time += (i == n - 1 ? curr : ceil(curr));
        }

        return time;
    }

    int minSpeedOnTime(vector<int>& dist, double hour) {
        int left = 0, right = 1e7 + 1;

        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (computeTime(dist, mid) <= hour) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right == 1e7 + 1 ? -1 : right;
    }
};
