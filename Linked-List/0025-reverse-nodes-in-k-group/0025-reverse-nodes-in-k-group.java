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
    public ListNode kthNode(ListNode head, int k) {
        while (k > 1 && head != null) {
            k -= 1;
            head = head.next;

        }
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        ListNode prev = null;
        ListNode front = null;
        while (t != null) {
            ListNode kth = kthNode(t, k);
            if (kth != null) {
                front = kth.next;
                kth.next = null;
            } else if (prev != null) {
                prev.next = t;
                break;
            }
            ListNode newhead = reverse(t);
            if (t == head)
                head = newhead;
            else
                prev.next = newhead;
            prev = t;
            t = front;
        }
        return head;
    }
}