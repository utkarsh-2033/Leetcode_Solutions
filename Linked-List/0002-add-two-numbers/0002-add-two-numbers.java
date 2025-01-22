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
        ListNode ans=new ListNode(0);
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode t3=ans;
        int carry=0;
        while(t1!=null && t2!=null){
            ListNode node =new ListNode((t1.val+t2.val+carry)%10);
            carry=(t1.val+t2.val+carry)/10;
            t3.next=node;
            t1=t1.next;
            t2=t2.next;
            t3=t3.next;
        }
        while(t1!=null){
            ListNode node =new ListNode((t1.val+carry)%10);
            carry=(t1.val+carry)/10;
            t3.next=node;
            t1=t1.next;
            t3=t3.next;
        }
        while(t2!=null){
            ListNode node =new ListNode((t2.val+carry)%10);
            carry=(t2.val+carry)/10;
            t3.next=node;
            t2=t2.next;
            t3=t3.next;
        }
        if(carry!=0){
            ListNode node =new ListNode(carry);
            t3.next=node;
        }
        return ans.next;
    }
}