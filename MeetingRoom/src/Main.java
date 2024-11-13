/*
Given an array of meeting time intervals consisting of start and end times. determine if a person could
attend all meetings
 */

import java.util.Scanner;

class MeetingRoom {
    private int start;
    private int end;

    MeetingRoom(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    private static int minMeetingRooms(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] startTimes = new int[array.length];
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }



    }
}