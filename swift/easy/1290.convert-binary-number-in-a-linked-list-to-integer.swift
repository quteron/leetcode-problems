func getDecimalValue(_ head: ListNode?) -> Int {
    var number = 0
    var current = head
    while (current != nil) {
        number *= 2
        number += current!.val
        current = current!.next
    }
    return number
}
