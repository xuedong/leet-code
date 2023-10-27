#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) {
            return "";
        }

        vector<int> ans = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            vector<int> curr = expand(s, i, i);

            if (curr[1] - curr[0] > ans[1] - ans[0]) {
                ans = curr;
            }

            if (i+1 < s.length() && s[i] == s[i+1]) {
                vector<int> curr = expand(s, i, i+1);

                if (curr[1] - curr[0] > ans[1] - ans[0]) {
                    ans = curr;
                }
            }
        }

        return s.substr(ans[0], ans[1] - ans[0] + 1);
    }

private:
    vector<int> expand(const string &s, int i, int j) {
        while (i >= 0 && j < s.length() && s[i] == s[j]) {
            i--;
            j++;
        }

        return {i+1, j-1};
    }
};
