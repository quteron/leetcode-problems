func deleteDuplicates(_ head: ListNode?) -> ListNode? {
    var current = head

    while (current?.next != nil) {
        if (current!.val == current!.next!.val) {
            current!.next = current!.next!.next
        } else {
            current = current!.next
        }
    }

    return head
}
