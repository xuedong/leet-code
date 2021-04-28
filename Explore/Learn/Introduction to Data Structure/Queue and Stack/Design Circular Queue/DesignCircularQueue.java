class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int k;

    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        if (isEmpty()) head++;
        tail = (tail + 1) % this.k;
        data[tail] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        data[head] = 0;
        if (head == tail) {
            head = tail = -1;
        } else {
            head = (head + 1) % this.k;
        }
        
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : data[head];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }
    
    public boolean isEmpty() {
        return head == tail && head == -1;
    }
    
    public boolean isFull() {
        return (tail + 1) % this.k == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
