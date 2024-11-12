#include <vector>

using namespace std;

class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        vector<int> results(queries.size());

        sort(items.begin(), items.end(), [](vector<int>& a, vector<int>& b) {
            return a[0] < b[0];
        });

        int maxBeauty = items[0][1];
        for (int i = 0; i < items.size(); i++) {
            maxBeauty = max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

        for (int i = 0; i < queries.size(); i++) {
            results[i] = binarySearch(items, queries[i]);
        }

        return results;
    }

    int binarySearch(vector<vector<int>>& items, int target) {
        int left = 0, right = items.size() - 1;

        int maxBeauty = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (items[mid][0] > target) {
                right = mid - 1;
            } else {
                maxBeauty = max(maxBeauty, items[mid][1]);
                left = mid + 1;
            }
        }

        return maxBeauty;
    }
};
