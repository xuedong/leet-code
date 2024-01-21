#include <vector>

using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        int hit = 0;
        int nohit = 0;

        for (int i = 0; i < nums.size(); i++) {
            int nexthit = nohit + nums[i];
            int nextnohit = max(nohit, hit);

            hit = nexthit;
            nohit = nextnohit;
        }

        return max(hit, nohit);
    }
};
