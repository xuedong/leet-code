#include <vector>

using namespace std;

class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        vector<int> counts(24, 0);
        
        for (int i = 0; i < 24; i++) {
            for (int num : candidates) {
                if ((num & (1 << i)) != 0) {
                    counts[i]++;
                }
            }
        }

        return *max_element(counts.begin(), counts.end());
    }
};
