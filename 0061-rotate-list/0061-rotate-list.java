/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // find size and tail -1pass
    // move a temp to n-k -2pass
    // taile.next=head ,head=k.next , k.next=null
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode temp = head;
        int size = 0;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        size++;
        ListNode tail = temp;
        temp = head;
        k=k%size;
        int c = size - k;
        while (c > 1) {
            temp = temp.next;
            c--;
        }
        tail.next=head;
        head=temp.next;
        temp.next=null;
        return head;
    }
}