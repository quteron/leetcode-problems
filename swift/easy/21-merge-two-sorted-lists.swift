func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
    var dummy = ListNode(0)
    var current = dummy

    var a = l1
    var b = l2

    while (a != nil || b != nil) {
        let vA = a?.val ?? Int.max
        let vB = b?.val ?? Int.max

        if vA <= vB {
            current.next = ListNode(vA)
            a = a?.next
        } else {
            current.next = ListNode(vB)
            b = b?.next
        }

        current = current.next!
    }

    return dummy.next
}
