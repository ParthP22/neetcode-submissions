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
    void reorderList(ListNode* head) {
        ListNode* dummy = new ListNode(0, head);

        ListNode* fast = dummy;
        ListNode* slow = dummy;

        while(fast != NULL && fast->next != NULL){
            fast = fast->next->next;
            slow = slow->next;
        }

        ListNode* curr1 = slow->next;
        slow->next = nullptr;
        ListNode* prev = slow->next;

        while(curr1 != NULL){
            ListNode* tmp = curr1->next;
            curr1->next = prev;
            prev = curr1;
            curr1 = tmp;
        }

        ListNode* curr2 = head;
        curr1 = prev;

        while(curr1 != NULL){
            ListNode* tmp1 = curr2->next;
            ListNode* tmp2 = curr1->next;

            curr2->next = curr1;
            curr1->next = tmp1;
            curr2 = tmp1;
            curr1 = tmp2;
        }

        
    }
};
