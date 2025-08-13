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
    public ListNode reverseList(ListNode head) {
        ListNode crr = head, rev = null, next;
        while(crr != null){
            next = crr.next;
            crr.next = rev;
            rev = crr;
            crr = next;
        }
        return rev;
    }
}
