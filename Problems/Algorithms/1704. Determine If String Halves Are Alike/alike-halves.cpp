#include <string>
#include <unordered_set>

using namespace std;

class Solution {
public:
    bool halvesAreAlike(string s) {
        auto countVowels = [](const string& str) {
            unordered_set<char> vowels{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            int count = 0;
            for (char c : str) {
                if (vowels.count(c) > 0) {
                    count++;
                }
            }
            return count;
        };
        
        int n = s.length();
        int mid = n / 2;

        string first = s.substr(0, mid);
        string second = s.substr(mid);

        return countVowels(first) == countVowels(second);
    }
};
