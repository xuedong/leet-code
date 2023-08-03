#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) {
            return {};
        }

        string map[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> results;
        backtrack("", digits, map, results);
        return results;
    }

    void backtrack(string combination, string rest, string map[], vector<string>& results) {
        if (rest.empty()) {
            results.push_back(combination);
            return;
        }

        string letters = map[rest[0] - '2'];
        for (char letter : letters) {
            backtrack(combination + letter, rest.substr(1), map, results);
        }
    }
};
