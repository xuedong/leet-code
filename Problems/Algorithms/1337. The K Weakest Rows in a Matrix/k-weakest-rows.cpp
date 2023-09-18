#include <vector>

using namespace std;

class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<pair<int, int>> strengths;
        for (int i = 0; i < mat.size(); i++) {
            int strength = accumulate(mat[i].begin(), mat[i].end(), 0);
            strengths.push_back({strength, i});
        }

        sort(strengths.begin(), strengths.end());

        vector<int> ans;
        for (int i = 0; i < k; i++) {
            ans.push_back(strengths[i].second);
        }

        return ans;
    }
};
