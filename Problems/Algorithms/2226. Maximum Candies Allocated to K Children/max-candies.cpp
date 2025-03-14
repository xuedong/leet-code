#include <vector>

using namespace std;

class Solution {
private:
    bool canAllocate(vector<int>& candies, long long k, int total) {
        long long int children = 0;

        for (int pile = 0; pile < candies.size(); pile++) {
            children += candies[pile] / total;
        }

        return children >= k;
    }

public:
    int maximumCandies(vector<int>& candies, long long k) {
        int maxCandies = 0;
        for (int i = 0; i < candies.size(); i++) {
            maxCandies = max(maxCandies, candies[i]);
        }

        int left = 0, right = maxCandies + 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;

            if (canAllocate(candies, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
};
