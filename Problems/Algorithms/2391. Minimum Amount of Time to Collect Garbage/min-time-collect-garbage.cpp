#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        int n = travel.size();

        vector<int> prefix(n+1, 0);
        prefix[1] = travel[0];
        for (int i = 1; i < n; i++) {
            prefix[i+1] = prefix[i] + travel[i];
        }

        unordered_map<char, int> lastPos;
        unordered_map<char, int> count;
        for (int i = 0; i < garbage.size(); i++) {
            for (char c : garbage[i]) {
                lastPos[c] = i;
                count[c]++;
            }
        }

        char types[3] = {'M', 'P', 'G'};
        int ans = 0;
        for (char c : types) {
            if (count[c]) {
                ans += prefix[lastPos[c]] + count[c];
            }
        }

        return ans;
    }
};
