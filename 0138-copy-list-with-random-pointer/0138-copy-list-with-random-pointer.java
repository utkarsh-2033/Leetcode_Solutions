/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    //1st pass - inserting new nodes with val in bw 
    //2nd pass setting the random pointers of new 
    //3rd pas - separating odd and even lists and by that setting the next 
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        //1st pass
        Node temp=head;
        while(temp!=null){
            Node t=new Node(temp.val);
            t.next=temp.next;
            temp.next=t;
            temp=t.next;
        }
        //2nd pass
        temp=head;
        while(temp!=null){
            if(temp.random!=null)
                temp.next.random=temp.random.next; //***
            temp=temp.next.next;
        }
        //3rd pass
        temp=head;
        Node copiedhead=temp.next;
        Node t=copiedhead;
        while (temp != null) {
            temp.next = t.next;
            temp = temp.next;
            if (temp != null) {
                t.next = temp.next;
                t = t.next;
            }
        }
        return copiedhead;
    }
}