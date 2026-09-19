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
    public boolean isPalindrome(ListNode head) {
        //1. Find middle node using fast and slow pointers
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //2. Skip the middle node for odd length
        if(fast != null){
            slow = slow.next;
        }

        //3. Reverse the second half of the list
        slow = reverse(slow);

        //4. Compare the fast and slow pointers
        fast = head;
        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
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
