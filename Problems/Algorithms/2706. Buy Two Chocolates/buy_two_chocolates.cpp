#include <vector>

using namespace std;

class Solution {
public:
    int buyChoco(vector<int>& prices, int money) {
        sort(prices.begin(), prices.end());

        int min = prices[0] + prices[1];
        if (min <= money) {
            return money - min;
        } else {
            return money;
        }
    }
};
