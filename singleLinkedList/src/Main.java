/*
This implementation was based upon:
https://www.youtube.com/watch?v=qp8u-frRAnU

Exceptions - Allows the code to break when an error occurs
Generics - An oop concept that allows to use other data types for the same functions/class,
read more here:
https://www.baeldung.com/java-generics
 */


public class Main {
    public static void main(String[] args) throws NodeExceptions {
        /*
        LinkedList<Integer> intList = new LinkedList<>();
        intList.insertAtBeginning(5);
        intList.insertAtBeginning(89);
        intList.insertAtEnd(99);
        intList.print();  // Output: 89-->5-->99-->

        LinkedList<String> strList = new LinkedList<>();
        strList.insertAtBeginning("Hello");
        strList.insertAtEnd("World");
        strList.print();  // Output: Hello-->World-->

        LinkedList<String> fruits = new LinkedList<>();
        String[] basket = {"Apple", "Banana", "Orange", "Grape"};
        fruits.insertValues(basket);
        fruits.removeAt(2);
        fruits.insertAt(0, "Figs");
        fruits.insertAt(0, "Date");
        fruits.print();
        fruits.insertAfterValue("Apple", "Gango");
        fruits.removeByValue("Date");
        fruits.print();
        fruits.removeByValue("Apple");
        fruits.print();
         */

        try {
            // Integer List Test
            LinkedList<Integer> intList = new LinkedList<>();
            intList.insertAtBeginning(1); // [1]
            intList.insertAtEnd(2);       // [1, 2]
            intList.insertAtEnd(3);       // [1, 2, 3]
            Integer[] intValues = {4, 5, 6};
            intList.insertValues(intValues); // [1, 2, 3, 4, 5, 6]
            intList.print();  // Expected: 1-->2-->3-->4-->5-->6-->

            // Insert at specific index
            intList.insertAt(2, 10); // Insert 10 at index 2 -> [1, 2, 10, 3, 4, 5, 6]
            intList.print();  // Expected: 1-->2-->10-->3-->4-->5-->6-->

            // Remove by value
            intList.removeByValue(10); // Remove 10 -> [1, 2, 3, 4, 5, 6]
            intList.print();  // Expected: 1-->2-->3-->4-->5-->6-->

            // Remove at specific index
            intList.removeAt(3); // Remove element at index 3 (4) -> [1, 2, 3, 5, 6]
            intList.print();  // Expected: 1-->2-->3-->5-->6-->
            System.out.println("Length: " + intList.get_length());  // Expected: 5

            // String List Test
            LinkedList<String> strList = new LinkedList<>();
            strList.insertAtBeginning("Hello"); // [Hello]
            strList.insertAtEnd("World");       // [Hello, World]
            strList.insertAtEnd("!");           // [Hello, World, !]
            String[] strValues = {"Java", "LinkedList"};
            strList.insertValues(strValues);    // [Hello, World, !, Java, LinkedList]
            strList.print();  // Expected: Hello-->World-->!-->Java-->LinkedList-->

            // Insert after value
            strList.insertAfterValue("World", "Beautiful");  // Insert "Beautiful" after "World" -> [Hello, World, Beautiful, !, Java, LinkedList]
            strList.print();  // Expected: Hello-->World-->Beautiful-->!-->Java-->LinkedList-->

            // Remove by value
            strList.removeByValue("!"); // Remove "!" -> [Hello, World, Beautiful, Java, LinkedList]
            strList.print();  // Expected: Hello-->World-->Beautiful-->Java-->LinkedList-->
            System.out.println("Length: " + strList.get_length());  // Expected: 5

        } catch (NodeExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}

