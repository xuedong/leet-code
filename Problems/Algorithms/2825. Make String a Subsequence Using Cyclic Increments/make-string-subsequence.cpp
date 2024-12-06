#include <string>

using namespace std;

class Solution {
public:
    bool canMakeSubsequence(string str1, string str2) {
        int len1 = str1.size(), len2 = str2.size();

        int index2 = 0;
        for (int index1 = 0; index1 < len1 && index2 < len2; index1++) {
            if (str1[index1] == str2[index2] || str1[index1] + 1 == str2[index2] || str1[index1] - 25 == str2[index2]) {
                index2++;
            }
        }

        return index2 == len2;
    }
};
