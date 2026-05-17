/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0){
            return l2;
        }
        if(l2.val == 0){
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode dTmp = dummy;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        boolean carry = false;

        while(tmp1 != null && tmp2 != null){
            int sum = tmp1.val + tmp2.val;
            if(carry){
                sum++;
            }
            if(sum >= 10){
                sum %= 10;
                
                carry = true;
                
            }
            else{
                carry = false;
            }
            dTmp.next = new ListNode(sum);
            dTmp = dTmp.next;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        while(tmp1 != null){
            int sum = tmp1.val;
            if(carry){
                sum++;
            }
            if(sum >= 10){
                sum %= 10;
                
                carry = true;
                
            }
            else{
                carry = false;
            }
            dTmp.next = new ListNode(sum);
            dTmp = dTmp.next;
            tmp1 = tmp1.next;
        }
        while(tmp2 != null){
            int sum = tmp2.val;
            if(carry){
                sum++;
            }
            if(sum >= 10){
                sum %= 10;
                
                carry = true;
                
            }
            else{
                carry = false;
            }
            dTmp.next = new ListNode(sum);
            dTmp = dTmp.next;
            tmp2 = tmp2.next;
        }
        if(carry){
            dTmp.next = new ListNode(1);
        }

        return dummy.next;


    }
}
