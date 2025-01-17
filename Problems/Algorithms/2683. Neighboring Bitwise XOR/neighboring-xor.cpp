#include <vector>

using namespace std;

class Solution {
public:
    bool doesValidArrayExist(vector<int>& derived) {
        int cum = 0;
        for (auto element : derived) {
            cum = cum ^ element;
        }

        return cum == 0;
    }
};
