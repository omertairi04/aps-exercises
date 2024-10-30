/*
<T> means the class can hold any data type
*/

public class LinkedList<T> {
    Node<T> head;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        while (head != null) {
            str.append(head.data);
            head = head.next;
        }
        return str.toString();
    }

    public LinkedList() {
        this.head = null;
    }

    public Node<T> insertAtBeginning(T data) {
        Node<T> node = new Node<>(data, this.head);
        this.head = node;
        return node;
    }

    public void insertAtEnd(T data) {
        if (this.head == null) {
            this.head = new Node<>(data, null);
            return;
        }

        Node<T> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node<>(data, null);
    }

    public void insertValues(T[] data) {
        for (T value : data) {
            insertAtEnd(value);
        }

    }

    public void print() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        }

        Node<T> temp = this.head;
        String llstr = "";
        while (temp != null) {
            llstr += temp.data + "-->";
            temp = temp.next;
        }

        System.out.println(llstr);
    }

    public int get_length() {
        int count = 0;
        Node<T> temp = this.head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public Node<T> removeAt(int index) throws NodeExceptions {
        if (index < 0 || index > this.get_length())
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            this.head = this.head.next;
            return head;
        }

        int count = 0;
        Node<T> temp = this.head;
        while (temp.next != null) {
            if (count == index - 1){
                temp.next = temp.next.next;
                return temp;
            }
            temp = temp.next;
            count++;
        }
        String iString = Integer.toString(index);
        throw new NodeExceptions("Node with index " + iString + " not found.");
    }

    public Node<T> insertAt(int index, T data) throws NodeExceptions {
        if (index < 0 || index > this.get_length())
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            Node<T> newNode = this.insertAtBeginning(data);
            return newNode;
        }

        int count = 0;
        Node<T> temp = this.head;
        while (temp.next != null) {
            if (count == index - 1){
                Node<T> node = new Node(data, temp.next);
                temp.next = node;
                return node;
            }
            temp = temp.next;
            count++;
        }

        throw new NodeExceptions("Node with index " + index + " not found.");
    }

    /*
    insert after value (data_after, data_to_insert)
    -> search for first occurrence of data_after value in LL
    -> Insert data_to_insert after data_after node
    */
    public Node<T> insertAfterValue(T dataAfter , T dataToInsert) throws NodeExceptions {

        Node<T> temp = this.head;
        int indexCount = 1;

        if (this.head.data == dataAfter) {
            return this.insertAt(0, dataToInsert);
        }

        while (temp.next != null) {
            if (temp.data == dataAfter) {
                return this.insertAt(indexCount, dataToInsert);
            }
            indexCount++;
            temp = temp.next;
        }

        throw new NodeExceptions("Something went wrong!");
    }

    // remove by value
    public Node<T> removeByValue(T dataToRemove) throws NodeExceptions {
        Node<T> temp = this.head;

        if (this.head.data == dataToRemove) {
            this.head = this.head.next;
            System.out.println("Head is " + this.head.data);
            return head;
        }
        while (temp.next != null) {
            if (temp.next.data == dataToRemove) {
                temp.next = temp.next.next;
                return temp;
            }
            temp = temp.next;
        }
        throw new NodeExceptions("Something went wrong!");
    }
}
