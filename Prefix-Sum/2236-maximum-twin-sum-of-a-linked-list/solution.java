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
    public int pairSum(ListNode head) {

        /*
        1. Find the middle node using fast and slow pointers
        2. Reverse the second half
        3. while second reaches the end, compare the sum of first and second values with the max value, update max value
        4. return max value;
        */
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        slow = reverseList(slow);

        int max = 0;
        while(slow != null){
            max = Math.max(max, (fast.val + slow.val));
            fast = fast.next;
            slow = slow.next;
        }

        return max;
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
