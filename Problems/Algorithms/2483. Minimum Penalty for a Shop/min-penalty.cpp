#include <string>

using namespace std;

class Solution {
public:
    int bestClosingTime(string customers) {
        int minPenalty = 0, curPenalty = 0;
        int ans = 0;

        for (int i = 0; i < customers.size(); i++) {
            char ch = customers[i];

            if (ch == 'Y') {
                curPenalty--;
            } else {
                curPenalty++;
            }

            if (curPenalty < minPenalty) {
                ans = i+1;
                minPenalty = curPenalty;
            }
        }

        return ans;
    }
};
