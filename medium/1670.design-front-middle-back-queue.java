class FrontMiddleBackQueue {

    private static class Node {
        public int val;
        public Node next;
        public Node prev;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    private int count = 0;

    private Node head = new Node();
    private Node middle;
    private Node tail = new Node();

    public FrontMiddleBackQueue() {
        head.next = tail;
        tail.prev = head;
    }

    public void pushFront(int val) {
        Node node = new Node(val);

        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;

        if (count == 0) {
            middle = node;
        } else if (count % 2 != 0) {
            middle = middle.prev;
        }

        count++;
    }

    public void pushMiddle(int val) {
        Node node = new Node(val);

        if (count == 0) {
            node.prev = head;
            node.next = tail;

            tail.prev = node;
            head.next = node;
        } else if (count % 2 == 0) {
            node.next = middle.next;
            node.prev = middle;

            middle.next.prev = node;
            middle.next = node;
        } else {
            node.prev = middle.prev;
            node.next = middle;

            middle.prev.next = node;
            middle.prev = node;
        }

        middle = node;
        count++;
    }

    public void pushBack(int val) {
        Node node = new Node(val);

        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;

        if (count == 0) {
            middle = node;
        } else if (count % 2 == 0) {
            middle = middle.next;
        }

        count++;
    }

    public int popFront() {
        if (count == 0) {
            return -1;
        }

        int val = head.next.val;
        remove(head.next);

        if (count % 2 == 0) {
            middle = middle.next;
        }

        count--;
        return val;
    }

    public int popMiddle() {
        if (count == 0) {
            return -1;
        }

        int val = middle.val;
        remove(middle);

        if (count % 2 != 0) {
            middle = middle.prev;
        } else {
            middle = middle.next;
        }

        count--;
        return val;
    }

    public int popBack() {
        if (count == 0) {
            return -1;
        }

        int val = tail.prev.val;
        remove(tail.prev);

        if (count % 2 != 0) {
            middle = middle.prev;
        }

        count--;
        return val;
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}
