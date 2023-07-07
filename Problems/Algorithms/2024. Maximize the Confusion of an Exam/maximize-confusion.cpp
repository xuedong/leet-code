#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int ans = k;

        unordered_map<char, int> count;
        for (int i = 0; i < k; i++) {
            count[answerKey[i]]++;
        }

        int left = 0;
        for (int right = k; right < answerKey.length(); right++) {
            count[answerKey[right]]++;

            while(min(count['T'], count['F']) > k) {
                count[answerKey[left]]--;
                left++;
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};
