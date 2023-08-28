#include <queue>

using namespace std;

class MyStack {
public:
    queue<int> queue1, queue2;

    MyStack() {}
    
    void push(int x) {
        while (queue1.size() > 0) {
            queue2.push(queue1.front());
            queue1.pop();
        }

        queue1.push(x);
        while (queue2.size() > 0) {
            queue1.push(queue2.front());
            queue2.pop();
        }
    }
    
    int pop() {
        int peek = queue1.front();
        queue1.pop();

        return peek;
    }
    
    int top() {
        return queue1.front();
    }
    
    bool empty() {
        return queue1.size() == 0;
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */