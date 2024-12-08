#include <vector>

using namespace std;

class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        sort(events.begin(), events.end());
        vector<vector<int>> dp(events.size(), vector<int>(3, -1));

        return find(events, 0, 0, dp);
    }

    int find(vector<vector<int>>& events, int index, int count, vector<vector<int>>& dp) {
        int n = events.size();
        if (count == 2 || index >= n) {
            return 0;
        }

        if (dp[index][count] == -1) {
            int end = events[index][1];

            int left = index + 1;
            int right = n - 1;
            while (right > left) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > end) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int include = events[index][2] + (left < n && events[left][0] > end ? find(events, left, count+1, dp) : 0);
            int exclude = find(events, index+1, count, dp);
            dp[index][count] = max(include, exclude);
        }

        return dp[index][count];
    }
};
