#include <vector>
#include <string>
#include <stack>

using namespace std;

class Solution {
private:
    long evaluate(int a, int b, char op) {
        if (op == '+') {
            return a+b;
        } else if (op == '-') {
            return a-b;
        } else if (op == '*') {
            return (long)a*b;
        }
        return a/b;
    }

public:
    int evalRPN(vector<string>& tokens) {
        stack<long> stk;

        int n = tokens.size();
        for (int i = 0; i < n; i++) {
            if (tokens[i].size() == 1 && tokens[i][0] < 48) {
                long b = stk.top();
                stk.pop();
                long a = stk.top();
                stk.pop();

                string op = tokens[i];
                long curr = evaluate(a, b, op[0]);
                stk.push(curr);
            } else {
                stk.push(stol(tokens[i]));
            }
        }

        return stk.top();
    }
};
