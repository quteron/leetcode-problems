func removeElements(_ head: ListNode?, _ val: Int) -> ListNode? {
    var dummy = ListNode(0)
    dummy.next = head

    var current = dummy
    while (current.next != nil) {
        if current.next!.val == val {
            current.next = current.next?.next
        } else {
            current = current.next!
        }
    }

    return dummy.next
}
