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

impl Solution {
    pub fn lowest_common_ancestor(root: Option<Rc<RefCell<TreeNode>>>, p: Option<Rc<RefCell<TreeNode>>>, q: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        let root = match root {
            Some(node) => node,
            None => return None,
        };
        
        let value1 = p.unwrap().borrow().val;
        let value2 = q.unwrap().borrow().val;
        Self::helper(root, value1, value2)
    }
    
    fn helper(root: Rc<RefCell<TreeNode>>, value1: i32, value2: i32) -> Option<Rc<RefCell<TreeNode>>> {
        let value = root.borrow().val;
        if value == value1 || value == value2 {
            return Some(root);
        }
        
        let left = root.borrow().left.as_ref().and_then(|node| Self::helper(node.clone(), value1, value2));
        let right = root.borrow().right.as_ref().and_then(|node| Self::helper(node.clone(), value1, value2));
        match (left, right) {
            (Some(_), Some(_)) => Some(root),
            (None, None) => None,
            (Some(left), None) => Some(left),
            (None, Some(right)) => Some(right),
        }
    }
}

