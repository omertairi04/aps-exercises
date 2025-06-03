import java.util.Scanner;
import java.util.Stack;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class QuasiStack<T extends Comparable<T>> {
    Node<T> head;
    Node<T> firstElement;
    public QuasiStack(){
        this.head = null;
        this.firstElement = null;
    }

    public boolean isEmpty() {
        return head == null && firstElement == null;
    }

    public void addElement(T element) {
        Node<T> createdNode = new Node<>(element);
        if (isEmpty()) {
            head = createdNode;
            firstElement = createdNode;
        } else {
            createdNode.next = head;
            this.head = createdNode;
        }
    }

    public T removeElement() {
        if (isEmpty()) return null;

        T headVal = head.data;
        T feVal = firstElement.data;

        if (headVal.compareTo(feVal) > 0) {
            // remove headVal;

        } else {
            // remvoe feVal
            this.firstElement = firstElement.next;
        }

        return headVal;

    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]"; // Empty list
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", "); // Add comma only if there's a next node
            }
            current = current.next;
        }

        sb.append("]\n");
        sb.append("feVal ");
        sb.append(this.firstElement.data);

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        QuasiStack<Integer> stack = new QuasiStack<>();

        for (int i=0;i<n;i++) {
            int input = sc.nextInt();
            sc.nextLine();

            stack.addElement(input);
        }

        System.out.println(stack);
    }
}