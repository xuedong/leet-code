#include <vector>

using namespace std;

class CustomStack {
private:
    vector<int> stack;
    int top;

public:
    CustomStack(int maxSize) {
        stack.resize(maxSize);
        top = -1;
    }
    
    void push(int x) {
        if (top < (int)(stack.size()) - 1) {
            stack[++top] = x;
        }
    }
    
    int pop() {
        if (top >= 0) {
            return stack[top--];
        }
        return -1;
    }
    
    void increment(int k, int val) {
        int limit = min(k, top + 1);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */