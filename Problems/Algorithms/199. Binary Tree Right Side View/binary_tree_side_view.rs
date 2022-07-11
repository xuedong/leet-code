// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
use std::collections::VecDeque;

impl Solution {
    pub fn right_side_view(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let root = match root {
            Some(node) => node,
            None => return vec![],
        };
        
        let mut results = vec![];
        let mut queue = VecDeque::new();
        queue.push_back(root);
        while queue.len() > 0 {
            let size = queue.len();
            for i in 0..size {
                let node = queue.pop_front().unwrap();
                
                if let Some(ref left) = node.borrow().left {
                    queue.push_back(left.clone());
                }
                
                if let Some(ref right) = node.borrow().right {
                    queue.push_back(right.clone());
                }
                
                if i == size-1 {
                    results.push(node.borrow().val);
                }
            }
        }
        
        results
    }
}

