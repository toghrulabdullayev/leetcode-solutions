# Definition for singly-linked list.
from ast import List
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None

        # works like merge sort without recursions
        while len(lists) > 1:
            mergedList = []

            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i + 1] if i + 1 < len(lists) else None  # if it has the second list during iteration
                mergedList.append(self.mergeList(l1,
                                                 l2))  # e.g. if the length of lists is 4, it becomes 2 and continues reducing by 2

            lists = mergedList  # update the lists

        return lists[0]

    def mergeList(self, l1, l2):
        dummy = ListNode()  # preserves the merged linked list
        tail = dummy

        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1 #! NOTE: although it adds the whole linked list l1 to the tail, the redundant elements get overshadowed on every update of the tail.next
                l1 = l1.next  # iterating through linked list l1
            else:
                tail.next = l2
                l2 = l2.next  # iterating through linked list l2
            tail = tail.next  # # iterating through linked list tail

        # as the l1 and l2 lists are sorted by default according to the description, just iterate through them one by one
        if l1:
            tail.next = l1
        if l2:
            tail.next = l2

        return dummy.next
