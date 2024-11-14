#include <vector>
#include <queue>
#include <cmath>

using namespace std;

class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        int m = quantities.size();

        auto compare = [](pair<int, int>& a, pair<int, int>& b) {
            return (long long)a.first * b.second < (long long)a.second * b.first;
        };

        vector<pair<int, int>> arr;
        for (int i = 0; i < m; i++) {
            arr.push_back({quantities[i], 1});
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(compare)> pairs(arr.begin(), arr.begin()+m);
        for (int i = 0; i < n-m; i++) {
            pair<int, int> maxPair = pairs.top();
            int qty = maxPair.first;
            int stores = maxPair.second;
            pairs.pop();

            pairs.push({qty, stores+1});
        }

        pair<int, int> maxPair = pairs.top();
        int qty = maxPair.first;
        int stores = maxPair.second;

        return ceil((double)qty / stores);
    }
};
