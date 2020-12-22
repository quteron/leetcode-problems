func hasCycle(_ head: ListNode?) -> Bool {
    var slow = head
    var fast = slow

    while fast?.next != nil {
        slow = slow!.next
        fast = fast!.next!.next

        if slow?.val == fast?.val {
            return true
        }
    }

    return false
}
