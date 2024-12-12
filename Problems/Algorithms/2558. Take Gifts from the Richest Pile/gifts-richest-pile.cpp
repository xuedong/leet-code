#include <vector>
#include <queue>
#include <cmath>

using namespace std;

class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        priority_queue<int> heap(gifts.begin(), gifts.end());

        for (int i = 0; i < k; i++) {
            int curr = heap.top();
            heap.pop();
            heap.push(sqrt(curr));
        }

        long long ans = 0;
        while (!heap.empty()) {
            ans += heap.top();
            heap.pop();
        }

        return ans;
    }
};
