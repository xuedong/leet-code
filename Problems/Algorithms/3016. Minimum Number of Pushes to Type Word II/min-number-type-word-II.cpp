#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int minimumPushes(string word) {
        vector<int> frequency(26, 0);
        for (char& ch : word) {
            frequency[ch-'a']++;
        }

        sort(frequency.rbegin(), frequency.rend());

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 0) {
                break;
            }

            ans += (i / 8 + 1) * frequency[i];
        }

        return ans;
    }
};
