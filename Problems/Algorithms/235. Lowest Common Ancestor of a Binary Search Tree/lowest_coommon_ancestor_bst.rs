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
        fn helper(root: Option<Rc<RefCell<TreeNode>>>, p_val: i32, q_val: i32) -> Option<Rc<RefCell<TreeNode>>> {
            match root {
                None => None,
                Some(node) => {
                    let node = node.borrow();

                    if (node.val - p_val) * (node.val - q_val) <= 0 {
                        return Some(Rc::new(RefCell::new(TreeNode::new(node.val))));
                    }

                    if node.val > q_val && node.val > p_val {
                        return helper(node.left.clone(), p_val, q_val)
                    }
                    helper(node.right.clone(), p_val, q_val)
                }
            }
        }
        
        let p_val = p.unwrap().borrow().val;
        let q_val = q.unwrap().borrow().val;
        helper(root, p_val, q_val)
    }
}

