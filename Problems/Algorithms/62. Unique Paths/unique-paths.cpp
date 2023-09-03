#include <algorithm>

using namespace std;

class Solution {
public:
    int uniquePaths(int m, int n) {
        if (n == 1) {
            return 1;
        }

        unsigned long long ans = 1LL;
        for (unsigned i = 1; i <= min(n-1, m-1); i++) {
            ans = ans * (n + m - 2 - min(n-1, m-1) + i) / i;
        }

        return ans;
    }
};
