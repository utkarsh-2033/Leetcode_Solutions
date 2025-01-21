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
    public ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeList(ListNode a ,ListNode b){
        ListNode dummy=new ListNode(-1);
        ListNode t=dummy;
        while(a!=null && b!=null){
            if(a.val>=b.val){
                t.next=b;
                b=b.next;
                t=t.next;
            }else{
                t.next=a;
                a=a.next;
                t=t.next;
            }
        }
        if(a!=null) t.next=a;
        if(b!=null) t.next=b;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode middle=middle(head);
        ListNode k=middle.next;
        middle.next=null;
        ListNode a= sortList(head);
        ListNode b= sortList(k);
        return mergeList(a,b);
        
    }
}