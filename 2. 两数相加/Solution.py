from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:

    #Solution 1
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        def helper (l1, l2, add):
            if l1 == None:
                l1, l2 = l2, l1
            if l1 == None:
                if add == 1:
                    return ListNode(1)
                else:
                    return None
            val = 0
            if l2 == None:
                nextNode = None
            else:
                val = l2.val
                nextNode = l2.next
            sum = l1.val + val + add
            if sum >= 10:
                add = 1
            else:
                add = 0
            return ListNode(sum % 10, helper(l1.next, nextNode, add))
        return helper(l1, l2, 0)

    #Solution 2
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = cur = None
        carry = 0
    
        while (l1 != None or l2 != None):
            if l1 == None:
                sum = l2.val + carry
                l2 = l2.next
            elif l2 == None:
                sum = l1.val + carry
                l1 = l1.next
            else:
                sum = l1.val + l2.val + carry
                l1 = l1.next
                l2 = l2.next

            carry = sum // 10
            sum = sum % 10
            if head == None:
                head = ListNode(sum)
                cur = head
            else:
                cur.next = ListNode(sum)
                cur = cur.next
        if carry == 1:
            cur.next = ListNode(1)
        return head