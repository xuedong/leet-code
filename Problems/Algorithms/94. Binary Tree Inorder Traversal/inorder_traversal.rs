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
    pub fn inorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut res = vec![];
        Self::helper(root, &mut res);
        res
    }

    fn helper(root: Option<Rc<RefCell<TreeNode>>>, res: &mut Vec<i32>) {
        match root {
            None => (),
            Some(node) => {
                let node = node.borrow();
                Self::helper(node.left.clone(), res);
                res.push(node.val);
                Self::helper(node.right.clone(), res);
            }
        }
    }
}
