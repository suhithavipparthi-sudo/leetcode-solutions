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
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1=reverse(l1);
        ListNode list2=reverse(l2);

        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        ListNode t1=list1;
        ListNode t2=list2;
        int carry=0;
        while(t1!=null || t2!=null){
            int sum=carry;
            if(t1!=null){
                sum+=t1.val;
                t1=t1.next;
            }
            if(t2!=null){
                sum+=t2.val;
                t2=t2.next;
            }
            ListNode newNode=new ListNode(sum%10);
            carry=sum/10;
            current.next=newNode;
            current=current.next;
        }
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            current.next=newNode;
        }
        ListNode ans=reverse(dummy.next);
        return ans;
        
    }
}