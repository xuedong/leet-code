#include <string>

using namespace std;

class Solution {
private:
    int map[26] = {0};

public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }

        for (int i = 0; i < s.size(); i++) {
            map[s[i]-'a']++;
        }
        for (int j = 0; j < t.size(); j++) {
            map[t[j]-'a']--;
        }

        for (int k = 0; k < 26; k++) {
            if (map[k] != 0) {
                return false;
            }
        }
        return true;
    }
};
