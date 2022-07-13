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
impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut dummy = Box::new(ListNode {
            val: -1,
            next: head,
        });
        
        let mut right = dummy.clone();
        for _ in 0..n {
            right = right.next.unwrap();
        }
        
        let mut left = dummy.as_mut();
        while let Some(node) = right.next {
            right = node;
            left = left.next.as_mut().unwrap();
        }
        
        left.next = left.next.as_mut().unwrap().next.clone();
        
        dummy.next
    }
}

