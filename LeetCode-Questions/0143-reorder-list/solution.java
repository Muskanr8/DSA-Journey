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
    public void reorderList(ListNode head) {
        if(head == null && head.next == null){
            return;
        }

        //1. Find the middle node
        ListNode fast = head, slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //2. Split the lists into 2 halves
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        //3. Reverse the second half
        second = reverseList(second);

        //4. Merge the two halves alternatively
        while(second != null){
            // temp node for next nodes
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            //connect the nodes
            first.next = second;
            second.next = t1;

            //move forward
            first = t1;
            second = t2;
        } 
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
