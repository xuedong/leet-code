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
    pub fn level_order(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        let mut res: Vec<Vec<i32>> = Vec::new();
        
        fn traversal(root: Option<Rc<RefCell<TreeNode>>>, res: &mut Vec<Vec<i32>>, level: usize) {
            match root {
                None => (),
                Some(r) => {
                    if res.len() == level {
                        res.push(Vec::new());
                    }
                    res[level].push(r.borrow().val);
                    traversal(r.borrow().left.clone(), res, level+1);
                    traversal(r.borrow().right.clone(), res, level+1);
                    ()
                }
            }
        }
        
        traversal(root.clone(), &mut res, 0);
        res
    }
}

