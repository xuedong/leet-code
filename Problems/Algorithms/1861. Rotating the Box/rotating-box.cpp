#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        int m = box.size(), n = box[0].size();
        vector<vector<char>> result(n, vector<char>(m, '.'));

        for (int i = 0; i < m; i++) {
            int lowest = n-1;
            for (int j = n-1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    result[lowest][m-i-1] = '#';
                    lowest--;
                }
                
                if (box[i][j] == '*') {
                    result[j][m-i-1] = '*';
                    lowest = j-1;
                }
            }
        }

        return result;
    }
};
