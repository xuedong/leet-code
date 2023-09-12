#include <unordered_map>
#include <unordered_set>
#include <string>

using namespace std;

class Solution {
public:
    int minDeletions(string s) {
        unordered_map<char, int> count;
        for (char ch : s) {
            count[ch]++;
        }

        int ans = 0;
        unordered_set<int> used;
        for (auto& pair : count) {
            int freq = pair.second;
            while (freq > 0 && used.find(freq) != used.end()) {
                freq--;
                ans++;
            }

            used.insert(freq);
        }

        return ans;
    }
};
