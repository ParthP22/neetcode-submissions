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

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;

        return curr;
    }

    //Recursion v1
    /*
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        return reverser(head,null);

    }

    public ListNode reverser(ListNode curr, ListNode prev){
        if(curr == null){
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return reverser(next,curr);
        
    }
    */
}
