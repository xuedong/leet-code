struct MyQueue {
    stack1: Vec<i32>,
    stack2: Vec<i32>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyQueue {

    fn new() -> Self {
        Self {
            stack1: Vec::new(),
            stack2: Vec::new(),
        }
    }
    
    fn push(&mut self, x: i32) {
        while !self.stack1.is_empty() {
            self.stack2.push(self.stack1.pop().unwrap());
        }
        self.stack1.push(x);
        while !self.stack2.is_empty() {
            self.stack1.push(self.stack2.pop().unwrap())
        }
    }
    
    fn pop(&mut self) -> i32 {
        self.stack1.pop().unwrap()
    }
    
    fn peek(&self) -> i32 {
        *self.stack1.last().unwrap()
    }
    
    fn empty(&self) -> bool {
        self.stack1.is_empty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * let obj = MyQueue::new();
 * obj.push(x);
 * let ret_2: i32 = obj.pop();
 * let ret_3: i32 = obj.peek();
 * let ret_4: bool = obj.empty();
 */
