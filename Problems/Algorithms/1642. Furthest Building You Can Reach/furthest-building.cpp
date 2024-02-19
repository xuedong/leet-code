#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        priority_queue<int> pq;

        int i = 0;
        while (i < heights.size() - 1) {
            int diff = heights[i+1] - heights[i];
            if (diff <= 0) {
                i++;
                continue;
            }

            bricks -= diff;
            pq.push(diff);

            if (bricks < 0) {
                bricks += pq.top();
                pq.pop();
                ladders--;
            }

            if (ladders < 0) {
                break;
            }

            i++;
        }

        return i;
    }
};
