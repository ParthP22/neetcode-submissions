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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* curr1 = l1;
        ListNode* curr2 = l2;

        ListNode* dummy = new ListNode();
        ListNode* curr3 = dummy;

        int carry = 0;
        int sum = 0;

        while(curr1 != nullptr && curr2 != nullptr){
            sum = curr1->val + curr2->val + carry;

            curr3->next = new ListNode(sum % 10);

            carry = sum / 10;


            curr1 = curr1->next;
            curr2 = curr2->next;
            curr3 = curr3->next;

        }  

        while(curr1 != nullptr){
            sum = curr1->val + carry;

            curr3->next = new ListNode(sum % 10);

            carry = sum / 10;

            curr1 = curr1->next;
            curr3 = curr3->next;
        } 
        
        while(curr2 != nullptr){
            sum = curr2->val + carry;

            curr3->next = new ListNode(sum % 10);

            carry = sum / 10;

            curr2 = curr2->next;
            curr3 = curr3->next;
        } 

        if(carry > 0){
            curr3->next = new ListNode(1);
        }

        return dummy->next;
    }
};
