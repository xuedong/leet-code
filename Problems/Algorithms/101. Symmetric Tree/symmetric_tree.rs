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
    pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match root {
            None => true,
            Some(n) => {
                let n = n.borrow();
                Self::aux(n.left.clone(), n.right.clone())
            },
        }
    }
    
    fn aux(left: Option<Rc<RefCell<TreeNode>>>, right: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match (left, right) {
            (None, None) => true,
            (_, None) | (None, _) => false,
            (Some(p), Some(q)) => {
                let p = p.borrow();
                let q = q.borrow();
                if p.val != q.val {
                    false
                } else {
                    Self::aux(p.left.clone(), q.right.clone()) && Self::aux(p.right.clone(), q.left.clone())
                }
            },
        }
    }
}

