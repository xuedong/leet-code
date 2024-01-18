#include <cmath>

using namespace std;

class Solution {
public:
    int climbStairs(int n) {
        return (1/sqrt(5))*(pow((1+sqrt(5))/2,n+1)-pow((1-sqrt(5))/2,n+1));
    }
};
