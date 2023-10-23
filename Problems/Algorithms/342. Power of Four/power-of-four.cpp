#include <cmath>

using namespace std;

class Solution {
public:
    bool isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0) {
            return false;
        }

        double log4 = log(n) / log(4);
        return (log4 == (int)log4);
    }
};
