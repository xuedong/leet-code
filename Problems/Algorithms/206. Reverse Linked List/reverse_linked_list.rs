// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
// 
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
use std::mem;

impl Solution {
    pub fn reverse_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        Self::helper(head, None)
    }
    
    pub fn helper(head: Option<Box<ListNode>>, rest: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        match head {
            None => rest,
            Some(mut node) => {
                let new_head = mem::replace(&mut node.next, rest);
                Self::helper(new_head, Some(node))
            }
        }
    }
}

