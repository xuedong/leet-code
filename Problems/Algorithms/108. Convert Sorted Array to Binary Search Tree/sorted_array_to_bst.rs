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
    pub fn sorted_array_to_bst(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        fn aux(nums: Vec<i32>, start: i32, end: i32) -> Option<Rc<RefCell<TreeNode>>> {
            if start > end {
                return None
            }

            let mid = start + (end - start) / 2;
            let mut root = Rc::new(RefCell::new(TreeNode::new(nums[mid as usize])));

            let (left, right) = (aux(nums.to_vec(), start, mid-1), aux(nums.to_vec(), mid+1, end));
            root.borrow_mut().left = left.clone();
            root.borrow_mut().right = right.clone();
    
            Some(root)
        }
        
        let n = nums.len();
        aux(nums, 0, (n-1) as i32)
    }
}

