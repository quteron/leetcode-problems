public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
    PolyNode output = new PolyNode();
    PolyNode current = output;

    PolyNode high = poly1;
    PolyNode low = poly2;
    while (high != null && low != null) {
        if (high.power < low.power) {
            PolyNode temp = high;
            high = low;
            low = temp;
        }

        if (high.power == low.power) {
            int sum = high.coefficient + low.coefficient;
            if (sum != 0) {
                current.next = new PolyNode(sum, high.power);
                current = current.next;
            }

            high = high.next;
            low = low.next;
        } else {
            current.next = new PolyNode(high.coefficient, high.power);
            current = current.next;
            high = high.next;
        }
    }

    current.next = high != null ? high : low;
    return output.next;
}
