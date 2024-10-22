public class DoubleLinkedList<T> {
    Node<T> head;

    public DoubleLinkedList(Node head) {
        this.head = head;
    }

    public Node<T> addNode(T data) {
        if (head == null) {
            Node<T> node = new Node<T>(data);
            this.head = node;
            return node;
        }

        Node<T> after = new Node<T>(data);
        head.next = after;
        after.prev = head;
        return after;
    }

    public Node<T> insertAtStart(T data) {
        Node<T> n = new Node<T>(data);

        if (head == null) {
            head = n;
            return n;
        }

        n.next = head;
        head.prev = n;
        head = n;
        return n;
    }

    public Node<T> insertAtEnd(T data) {
        Node<T> n = new Node<T>(data);

        if (head == null) {
            head = n;
            return n;
        }

        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = n;
        n.prev = curr;
        return n;
    }

    public Node<T> insertAfterValue(T valueAfter, T valueToInsert) {
        if (head == null) {
            return insertAtStart(valueToInsert);
        }

        Node<T> curr = head;

        while(curr != null) {
            if (curr.data == valueAfter) {
                Node<T> newVal = new Node<T>(valueToInsert);
                newVal.next = curr.next;
                curr.next = newVal;
                newVal.prev = curr;

                // if newVal is not last node, update last nodes prev
                if (newVal.next != null) {
                    newVal.next.prev = newVal;
                }
                return newVal;
            }
            curr = curr.next;
        }

        // if val is not found;
        System.out.println("Value " + valueToInsert + " not found");
        return null;
    }

    public Node<T> deleteAtStart() {
        Node<T> toDel = head;
        if (head == null || head.next == null) {
            head = null;
            return toDel;
        }

        head = head.next;
        head.prev = null;
        return toDel;
    }

    public Node<T> deleteAtEnd() {
        Node<T> toDel = head;
        if (head == null || head.next == null) {
            head = null;
            return toDel;
        }

        while (toDel.next != null) {
            toDel = toDel.next;
        }
        return toDel.prev.next = null;
    }

    public Node<T> deleteAfterValue(T afterVal) {
        if (head == null) {
            return null;
        }

        Node<T> curr = head;
        while (curr != null) {
            if (curr.data == afterVal) {
                if (curr.next == null) {
                    return null;
                }

                Node<T> toDel = curr.next; // The node to delete

                // If toDel is not the last node, update the next node's prev pointer
                if (toDel.next != null) {
                    toDel.next.prev = curr;
                }

                // Link curr to the node after toDel
                curr.next = toDel.next;

                // Unlink the toDel node from the list
                toDel.next = null;
                toDel.prev = null;

                return toDel;
            }
            curr = curr.next;
        }

        return null; // Return null if afterVal is not found
    }
}
