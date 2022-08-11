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
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        fn aux(root: Option<Rc<RefCell<TreeNode>>>, min_value: i64, max_value: i64) -> bool {
            match root {
                None => true,
                Some(node) => {
                    let node = node.borrow();
                    if (node.val as i64) > min_value && (node.val as i64) < max_value {
                        return aux(node.left.clone(), min_value, node.val as i64) && aux(node.right.clone(), node.val as i64, max_value);
                    }
                    false
                },
            }
        }

        aux(root, -2147483649, 2147483648)
    }
}

