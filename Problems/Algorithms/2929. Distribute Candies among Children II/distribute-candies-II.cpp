using namespace std;

class Solution {
private:
    long long cn2(int x) {
        if (x < 0) {
            return 0;
        }
        return (long) x * (x - 1) / 2;
    }

public:
    long long distributeCandies(int n, int limit) {
        return cn2(n + 2) - 3 * cn2(n - limit + 1) + 3 * cn2(n - (limit + 1) * 2 + 2) - cn2(n - 3 * (limit + 1) + 2);
    }
};
