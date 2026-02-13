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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (size == 1) return null;

        temp = head;
        int tempSize = size - n - 1;

        if (n == size) {
            return head.next;
        }

        while (tempSize > 0) {
            temp = temp.next;
            tempSize--;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            temp.next = null;
        }

        return head;
    }
}
