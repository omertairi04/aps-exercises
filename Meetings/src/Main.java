import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of meetings
        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];

        // Read each meeting's start and end time
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings[i] = new Meeting(start, end);
        }

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        // Priority queue to track end times of meetings currently using rooms
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();

        for (Meeting meeting : meetings) {
            // If the earliest ending room is free, remove it from the queue
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= meeting.start) {
                roomEndTimes.poll();
            }

            // Allocate a new room (add the meeting's end time to the queue)
            roomEndTimes.add(meeting.end);
        }

        // The size of the priority queue is the minimum number of rooms required
        System.out.println(roomEndTimes.size());
    }
}
