#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        if (s.empty() || t.empty() || s.length() < t.length()) {
            return "";
        }

        vector<int> map(128, 0);
        int count = t.length();
        int start = 0, end = 0;
        int ans = INT_MAX, i = 0;
        for (char ch : t) {
            map[ch]++;
        }

        while (end < s.length()) {
            if (map[s[end++]]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (end - start < ans) {
                    i = start;
                    ans = end - start;
                }

                if (map[s[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return ans == INT_MAX ? "" : s.substr(i, ans);
    }
};
