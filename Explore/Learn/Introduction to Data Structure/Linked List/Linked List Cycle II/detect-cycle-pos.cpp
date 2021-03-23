/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        bool flag = false;
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast && fast->next) {
            fast = fast->next->next;
            slow = slow->next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        
        if (flag) {
            // int idx = 0;
            ListNode *current = head;
            while (current != slow) {
                // idx += 1;
                current = current->next;
                slow = slow->next;
            }
            return current;
        }
        
        return NULL;
    }
};

