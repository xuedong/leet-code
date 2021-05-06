class MinStack {
    private List<Integer> data;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        data.add(val);
        if (min.isEmpty() || min.peek() >= val) min.push(val);
    }
    
    public void pop() {
        int peek = data.get(data.size()-1);
        data.remove(data.size()-1);
        if (peek == min.peek()) min.pop();
    }
    
    public int top() {
        return data.get(data.size()-1);
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
