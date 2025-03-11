#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int numberOfSubstrings(string s) {
        int n = s.length();
        int left = 0, right = 0;
        vector<int> freq(3, 0);
        int total = 0;

        while (right < n) {
            char curr = s[right];
            freq[curr-'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                total += n - right;
                freq[s[left]-'a']--;
                left++;
            }
            right++;
        }

        return total;
    }
};
