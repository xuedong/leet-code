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
    pub fn is_palindrome(mut head: Option<Box<ListNode>>) -> bool {
        let mut values = vec![];
        while let Some(node) = head {
            values.push(node.val);
            head = node.next;
        }

        let reversed = values.iter().rev().cloned().collect::<Vec<_>>();
        values == reversed
    }
}
