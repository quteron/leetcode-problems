func isPalindrome(_ head: ListNode?) -> Bool {
    if (head == nil) {
        return true
    }

    let middle = findMiddle(head)
    var last = reverse(middle)
    var first = head

    while (first != nil && last != nil) {
        if (first!.val != last!.val) {
            return false
        } else {
            first = first!.next
            last = last!.next
        }
    }

    return true
}

func findMiddle(_ head: ListNode?) -> ListNode? {
    var slow = head
    var fast = head

    while (fast?.next != nil) {
        slow = slow!.next
        fast = fast!.next!.next
    }

    return slow
}

func reverse(_ head: ListNode?) -> ListNode? {
    var prev: ListNode? = nil
    var current = head

    while (current != nil) {
        let next = current!.next
        current!.next = prev
        prev = current
        current = next
    }

    return prev
}
