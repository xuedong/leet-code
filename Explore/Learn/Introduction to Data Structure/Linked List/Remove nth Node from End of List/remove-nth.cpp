/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {     
        ListNode *before = new ListNode(-1, head);
        ListNode *after = new ListNode(-1, head);
        
        for (int i = 1; i <= n; i++) {
            before = before->next;
            if (before == nullptr) {
                return nullptr;
            }
        }
        
        while (before->next) {
            before = before->next;
            after = after->next;
        }
        
        if (after->next) {
            after->next = after->next->next;
            if (after->val == -1) head = after->next; 
        } else {
            return nullptr;
        }
        
        return head;
    }
};

