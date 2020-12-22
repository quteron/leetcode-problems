// recursion
func addTwoNumbers(_ a: ListNode?, _ b: ListNode?) -> ListNode? {
    return addTwoNumbers(a, b, 0)
}

func addTwoNumbers(_ a: ListNode?, _ b: ListNode?, _ carry: Int) -> ListNode? {
    if (a == nil && b == nil) {
        return carry > 0 ? ListNode(carry) : nil
    }

    let vA = a?.val ?? 0
    let vB = b?.val ?? 0
    let sum = vA + vB + carry

    var node = ListNode(sum % 10)
    node.next = addTwoNumbers(a?.next, b?.next, sum / 10)
    return node
}

// iteration
func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
    var a = l1
    var b = l2

    var dummy = ListNode(0)
    var current = dummy

    var carry = 0
    while (a != nil || b != nil) {
        let vA = a?.val ?? 0
        let vB = b?.val ?? 0
        let sum = vA + vB + carry

        carry = sum / 10
        current.next = ListNode(sum % 10)

        current = current.next!
        a = a?.next
        b = b?.next
    }

    if carry > 0 {
        current.next = ListNode(carry)
    }

    return dummy.next
}
