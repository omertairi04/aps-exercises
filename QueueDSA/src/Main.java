import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        /*
        FIFO DSA - (First In, First Out)
         */

        Queue<String> queue = new LinkedList<String>();

        queue.offer("Karen"); // adds to queue
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        System.out.println(queue.peek()); // prints first item on the queue
        queue.poll(); // removes first item on the queue
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.contains("Harold"));
        System.out.println(queue);
    }
}