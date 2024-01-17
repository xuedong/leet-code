#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> freq;
        for (auto x : arr) {
            freq[x]++;
        }

        unordered_set<int> set;
        for (auto x : freq) {
            set.insert(x.second);
        }

        return freq.size() == set.size();
    }
};
