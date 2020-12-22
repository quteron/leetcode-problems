func deleteNodes(_ head: ListNode?, _ m: Int, _ n: Int) -> ListNode? {
    var dummy = ListNode(0)
    dummy.next = head

    var current: ListNode? = dummy
    while (current != nil) {
        var i = 0
        while current != nil && i < m {
            current = current?.next
            i += 1
        }

        i = 0
        while current != nil && i < n {
            current!.next = current!.next?.next
            i += 1
        }
    }

    return dummy.next
}
