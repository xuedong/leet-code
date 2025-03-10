#include <unordered_map>
#include <string>
#include <vector>

using namespace std;

class Solution {
private:
    bool isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

public:
    long long countOfSubstrings(string word, int k) {
        long ans = 0;
        int n = word.size();

        int start = 0, end = 0;
        unordered_map<char, int> vowels;
        int consonants = 0;

        vector<int> nextConsonant(n);
        int nextIndex = n;
        for (int i = n-1; i >= 0; i--) {
            nextConsonant[i] = nextIndex;
            if (!isVowel(word[i])) {
                nextIndex = i;
            }
        }

        while (end < n) {
            char newLetter = word[end];
            if (isVowel(newLetter)) {
                vowels[newLetter]++;
            } else {
                consonants++;
            }

            while (consonants > k) {
                char startLetter = word[start];
                if (isVowel(startLetter)) {
                    vowels[startLetter]--;

                    if (vowels[startLetter] == 0) {
                        vowels.erase(startLetter);
                    }
                } else {
                    consonants--;
                }
                
                start++;
            }

            while (start < n && vowels.size() == 5 && consonants == k) {
                ans += nextConsonant[end] - end;

                char startLetter = word[start];
                if (isVowel(startLetter)) {
                    vowels[startLetter]--;

                    if (vowels[startLetter] == 0) {
                        vowels.erase(startLetter);
                    }
                } else {
                    consonants--;
                }

                start++;
            }
            end++;
        }

        return ans;
    }
};
