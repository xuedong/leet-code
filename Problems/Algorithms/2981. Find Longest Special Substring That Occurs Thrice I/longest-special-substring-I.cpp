#include <string>
#include <map>

using namespace std;

class Solution {
public:
    int maximumLength(string s) {
        map<pair<char, int>, int> count;

        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s[i];
            len = 0;
            for (int j = i; i < s.length(); j++) {
                if (ch == s[j]) {
                    len++;
                    count[{ch, len}]++;
                } else {
                    break;
                }
            }
        }

        int ans = 0;
        for (auto pair : count) {
            int len = pair.first.second;
            if (pair.second >= 3 && len > ans) {
                ans = len;
            }
        }

        if (ans == 0) {
            return -1;
        }
        return ans;
    }
};
