#include <vector>

using namespace std;

bool comparator(vector<int>& a, vector<int>& b) {
    return a[1] < b[1];
}

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), comparator);

        int ans = 0;
        int last = INT_MIN;

        for (int i = 0; i < intervals.size(); i++) {
            int x = intervals[i][0], y = intervals[i][1];

            if (x >= last) {
                last = y;
            } else {
                ans++;
            }
        }

        return ans;
    }
};
