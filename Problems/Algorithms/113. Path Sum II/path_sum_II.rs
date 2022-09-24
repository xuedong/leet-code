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
    pub fn path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> Vec<Vec<i32>> {
        let mut results = Vec::new();
        let mut curr = Vec::new();

        Self::dfs(&root, target_sum, &mut curr, &mut results);

        results
    }

    fn dfs(root: &Option<Rc<RefCell<TreeNode>>>, target_sum: i32, curr: &mut Vec<i32>, results: &mut Vec<Vec<i32>>) {
        if let Some(node) = root {
            let node = node.borrow();
            curr.push(node.val);

            if node.left.is_none() && node.right.is_none() && node.val == target_sum {
                results.push(curr.clone());
            } else {
                Self::dfs(&node.left, target_sum - node.val, curr, results);
                Self::dfs(&node.right, target_sum - node.val, curr, results);
            }

            curr.pop();
        }
    }
}
