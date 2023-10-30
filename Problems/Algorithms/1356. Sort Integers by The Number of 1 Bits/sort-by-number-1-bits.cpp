#include <vector>

using namespace std;

class Solution {
public:
    static bool comparator(int a, int b) {
        int bitsA = __builtin_popcount(a);
        int bitsB = __builtin_popcount(b);

        if (bitsA == bitsB) {
            return a < b;
        }
        return bitsA < bitsB;
    }

    vector<int> sortByBits(vector<int>& arr) {
        sort(arr.begin(), arr.end(), comparator);

        return arr;
    }
};
