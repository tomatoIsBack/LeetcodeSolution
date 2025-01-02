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

    //Solution 1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    public ListNode helper (ListNode l1, ListNode l2, int add){
        if (l1 == null) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        if (l1 == null){
            if (add == 1) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        int val = 0;
        ListNode next = null;
        if (l2 != null) {
            val = l2.val;
            next = l2.next;
        }
        int sum = l1.val + val + add;
        if (sum >= 10) {
            add = 1;
        } else {
            add = 0;
        }
        return new ListNode(sum % 10, helper(l1.next, next, add));
    }

    //Solution 2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum;
        ListNode head = null;
        ListNode cur = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                head = new ListNode(sum);
                cur = head;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head;
    }



}
