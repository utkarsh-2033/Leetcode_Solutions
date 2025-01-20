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
    // public ListNode reverse(ListNode head){
    //     ListNode prev=null;
    //     ListNode n=null;
    //     ListNode curr=head;
    //     while(curr!=null){
    //         n=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=n;
    //     }
    //     return prev;
    // }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head==null) return false;
        if(head.next==null) return true;
        while(fast.next!=null && fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode n=null;
        ListNode curr=slow.next;
        while(curr!=null){
            n=curr.next;
            curr.next=prev;
            prev=curr;
            curr=n;
        }
        // ListNode t=reverse(slow.next);
        slow.next=prev;
        fast=head;
        while(prev!=null){
            if(fast.val!=prev.val) return false;
            fast=fast.next;
            prev=prev.next;
        }
        return true;
    }
}