using namespace std;

class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int consumed = 0, rest = numBottles;

        while (rest >= numExchange) {
            int curr = rest / numExchange;

            consumed += numExchange * curr;
            rest -= numExchange * curr;

            rest += curr;
        }

        return rest + consumed;
    }
};
