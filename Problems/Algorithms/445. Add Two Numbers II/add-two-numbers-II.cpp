#include <stack>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        stack<int> stack1, stack2;

        while (l1 != nullptr) {
            stack1.push(l1->val);
            l1 = l1->next;
        }
        while (l2 != nullptr) {
            stack2.push(l2->val);
            l2 = l2->next;
        }

        int sum = 0, carry = 0;
        ListNode* ans = new ListNode();
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) {
                sum += stack1.top();
                stack1.pop();
            }
            if (!stack2.empty()) {
                sum += stack2.top();
                stack2.pop();
            }

            ans->val = sum % 10;
            carry = sum / 10;
            ListNode* curr = new ListNode(carry);
            curr->next = ans;
            ans = curr;
            sum = carry;
        }

        return carry == 0 ? ans->next : ans;
    }
};
