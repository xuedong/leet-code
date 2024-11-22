#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        unordered_map<string, int> patterns;

        for (auto& curr : matrix) {
            string builder = "";
            for (int col = 0; col < curr.size(); col++) {
                if (curr[0] == curr[col]) {
                    builder += "1";
                } else {
                    builder += "0";
                }
            }

            patterns[builder]++;
        }

        int ans = 0;
        for (auto& pattern : patterns) {
            ans = max(ans, pattern.second);
        }

        return ans;
    }
};
