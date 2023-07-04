#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ones = 0;
        int twos = 0;

        for (const auto num : nums) {
            ones = ((ones ^ num) & (~twos));
            twos = ((twos ^ num) & (~ones));
        }

        return ones;
    }
};
