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
    ListNode* oddEvenList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;
        
        ListNode *odd = head;
        ListNode *even = head->next;
        ListNode *second = head->next;
        
        while (odd && even && even->next) {
            odd->next = even->next;
            odd = even->next;
            
            if (odd->next == nullptr) {
                odd->next = second;
                even->next = nullptr;
                return head;
            }
            even->next = odd->next;
            even = odd->next;
        }
        
        odd->next = second;
        return head;
    }
};

