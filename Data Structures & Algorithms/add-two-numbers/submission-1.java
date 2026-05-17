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
        ListNode dummy = new ListNode(0);

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode curr3 = dummy;

        int carry = 0;

        while(curr1 != null && curr2 != null){
            curr3.next = new ListNode((curr1.val + curr2.val + carry) % 10);
            carry = (curr1.val + curr2.val + carry) / 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
            curr3 = curr3.next;
        }

        while(curr1 != null){
            curr3.next = new ListNode((curr1.val + carry) % 10);
            carry = (curr1.val + carry) / 10;
            curr1 = curr1.next;
            curr3 = curr3.next;
        }

        while(curr2 != null){
            curr3.next = new ListNode((curr2.val + carry) % 10);
            carry = (curr2.val + carry) / 10;
            curr2 = curr2.next;
            curr3 = curr3.next;
        }

        if(carry == 1){
            curr3.next = new ListNode(1);
        }

        return dummy.next;
    }
}
