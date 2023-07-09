#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int largestVariance(string s) {
        vector<int> counts(26, 0);
        for (char ch : s) {
            counts[ch - 'a']++;
        }

        int global = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || counts[i] == 0 || counts[j] == 0) {
                    continue;
                }

                char major = 'a' + i, minor = 'a' + j;
                int majorCount = 0, minorCount = 0;

                int rest = counts[j];
                for (char ch : s) {
                    if (ch == major) {
                        majorCount++;
                    }
                    if (ch == minor) {
                        minorCount++;
                        rest--;
                    }

                    if (minorCount > 0) {
                        global = max(global, majorCount - minorCount);
                    }

                    if (majorCount < minorCount && rest > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }

        return global;
    }
};
