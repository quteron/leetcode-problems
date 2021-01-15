class MyLinkedList {

    private static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node current = head;
        while (current != null && index != 0) {
            current = current.next;
            index--;
        }

        return current == null ? -1 : current.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        }

        Node current = head;
        while (current != null && index != 1) {
            current = current.next;
            index--;
        }

        if (current != null) {
            Node node = new Node(val);
            node.next = current.next;
            current.next = node;

            if (tail == current) {
                tail = node;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        if (index == 0) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        }

        Node current = head;
        while (current != null && index != 1) {
            current = current.next;
            index--;
        }

        if (current != null && current.next != null) {
            if (tail == current.next) {
                tail = current;
            }

            current.next = current.next.next;
        }
    }
}
