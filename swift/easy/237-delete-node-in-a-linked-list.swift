func deleteNode(_ node: ListNode?) {
    if node == nil {
        return
    }

    node!.val = node!.next!.val
    node!.next = node!.next!.next
}
