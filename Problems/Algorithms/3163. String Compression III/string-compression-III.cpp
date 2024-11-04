#include <string>

using namespace std;

class Solution {
public:
    string compressedString(string word) {
        string comp = "";

        int pos = 0;
        while (pos < word.length()) {
            int count = 0;

            char curr = word[pos];
            while (pos < word.length() && count < 9 && word[pos] == curr) {
                count++;
                pos++;
            }

            comp += to_string(count) + curr;
        }

        return comp;
    }
};
