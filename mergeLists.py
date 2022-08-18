class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def get_value(self):
        return self.val

    def get_next(self):
        return self.next


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        else:
            if l1.val < l2.val:
                l1.next = self.mergeTwoLists(l1.next, l2)
                return l1
            else:
                l2.next = self.mergeTwoLists(l1, l2.next)
                return l2


if __name__ == '__main__':
    temp_object = Solution()

    # List 1 -
    a3 = ListNode(3)
    a2 = ListNode(2, a3)
    a1 = ListNode(1, a2)

    # List 2 -
    b3 = ListNode(4)
    b2 = ListNode(2, b3)
    b1 = ListNode(1, b2)

    result = temp_object.mergeTwoLists(a1, b1)

    while result is not None:
        print(result.get_value(), end=' -> ')
        result = result.get_next()
