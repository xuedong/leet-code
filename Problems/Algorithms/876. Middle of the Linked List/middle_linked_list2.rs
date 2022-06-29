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
    pub fn middle_node(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let (mut curr, mut count) = (head.clone(), 0);
        while let Some(node) = curr {
            curr = node.next;
            count += 1;
        }

        (0..count/2).for_each(|_| head = head.clone().unwrap().next);
        head
    }
}

