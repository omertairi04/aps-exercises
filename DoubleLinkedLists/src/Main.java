public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> integerList = new DoubleLinkedList<>(null);

        // Test: Inserting at the start with Integer type
        System.out.println("Testing insertAtStart with Integer type...");
        integerList.insertAtStart(10); // List: 10
        integerList.insertAtStart(5);  // List: 5 -> 10
        printList(integerList); // Expected output: 5 10

        // Test: Inserting at the end with Integer type
        System.out.println("\nTesting insertAtEnd with Integer type...");
        integerList.insertAtEnd(20);  // List: 5 -> 10 -> 20
        integerList.insertAtEnd(25);  // List: 5 -> 10 -> 20 -> 25
        printList(integerList); // Expected output: 5 10 20 25

        // Test: Inserting after a specific value with Integer type
        System.out.println("\nTesting insertAfterValue with Integer type...");
        integerList.insertAfterValue(10, 15); // List: 5 -> 10 -> 15 -> 20 -> 25
        printList(integerList); // Expected output: 5 10 15 20 25

        // Test: Deleting at the start with Integer type
        System.out.println("\nTesting deleteAtStart with Integer type...");
        integerList.deleteAtStart(); // List: 10 -> 15 -> 20 -> 25
        printList(integerList); // Expected output: 10 15 20 25

        // Test: Deleting at the end with Integer type
        System.out.println("\nTesting deleteAtEnd with Integer type...");
        integerList.deleteAtEnd(); // List: 10 -> 15 -> 20
        printList(integerList); // Expected output: 10 15 20

        // Test: Inserting at the start with String type
        DoubleLinkedList<String> stringList = new DoubleLinkedList<>(null);
        System.out.println("\nTesting insertAtStart with String type...");
        stringList.insertAtStart("Hello");  // List: Hello
        stringList.insertAtStart("World");  // List: World -> Hello
        printList(stringList); // Expected output: World Hello

        // Test: Inserting after a specific value with String type
        System.out.println("\nTesting insertAfterValue with String type...");
        stringList.insertAfterValue("World", "Java");  // List: World -> Java -> Hello
        printList(stringList); // Expected output: World Java Hello

        // Test: Deleting after a specific value with String type
        System.out.println("\nTesting deleteAfterValue with String type...");
        stringList.deleteAfterValue("Java");  // List: World -> Java
        printList(stringList); // Expected output: World Java
    }

    // Helper function to print the list
    public static <T> void printList(DoubleLinkedList<T> list) {
        Node<T> current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
