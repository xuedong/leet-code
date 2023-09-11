#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> ans;
        unordered_map<int, vector<int>> group;

        int n = groupSizes.size();
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            group[size].push_back(i);

            if (group[size].size() == size) {
                ans.push_back(group[size]);
                group[size].clear();
            }
        }

        return ans;
    }
};
