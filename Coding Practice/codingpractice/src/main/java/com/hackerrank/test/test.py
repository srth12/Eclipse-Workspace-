# You are given two non-empty linked lists representing two non-negative integers.
#  The digits are stored in reverse order, and each of their nodes contains a single digit. 
# Add the two numbers and return the sum as a linked list.

# You may assume the two numbers do not contain any leading zero, except the number 0 itself.

# Definition for singly-linked list.

# 12  ll1: 2 -> 1
# 13  ll2: 3 -> 1

# 2, 13 : 2 ->
# 3, 1

# 25  result: 5 -> 2

# ll1 -> 0
# ll2 -> 4

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        carry = 0
        sum_ele = 0
        result = ListNode()
        head = result

        while(l1 != None and l2 != None):
            sum_ele = l1.val + l2.val + carry

            carry = sum_ele // 10
            result.val = sum_ele % 10
            result.next = ListNode()
            result = result.next

            l1 = l1.next
            l2 = l2.next
        
        # If both the list are not equal
        if l1 is None:
            while l2 != None:
                sum_ele = l2.val + carry

                carry = sum_ele // 10
                result.val = sum_ele % 10
                result.next = ListNode()
                result = result.next

                l2 = l2.next

        elif l2 is None:
            while l1 != None:
                sum_ele = l2.val + carry

                carry = sum_ele // 10
                result.val = sum_ele % 10
                result.next = ListNode()
                result = result.next

                l1 = l1.next
        
        if carry != 0:
            result.val = carry
        
        return head

if __name__ == "__main__":
    # l1 -> 1 2 9
    l1 = ListNode(val=9)
    # l1.next = ListNode(val=1)

    l2 = ListNode(val=9)
    temp = ListNode(val=9)
    l2.next = ListNode(val=9, next=temp)
    
    s = Solution()
    result = s.addTwoNumbers(l1, l2)

    while result != None:
        print(result.val)
        result = result.next
