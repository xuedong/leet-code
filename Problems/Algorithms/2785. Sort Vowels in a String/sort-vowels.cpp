#include <string>

using namespace std;

class Solution {
public:
    bool isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'o'|| ch == 'u'|| ch == 'i' 
        || ch == 'A' || ch == 'E' || ch == 'O'|| ch == 'U'|| ch == 'I';
    }

    string sortVowels(string s) {
        string vowels;
        for (char ch : s) {
            if (isVowel(ch)) {
                vowels += ch;
            }
        }

        sort(vowels.begin(), vowels.end());

        int j = 0;
        string ans;
        for (int i = 0; i < s.size(); i++) {
            if (isVowel(s[i])) {
                ans += vowels[j];
                j++;
            } else {
                ans += s[i];
            }
        }

        return ans;
    }
};
