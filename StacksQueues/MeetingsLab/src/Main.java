import java.util.Scanner;
import java.util.HashMap;

class Metting {
    int start;
    int end;

    Metting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Metting [start=" + getStart() + ", end=" + getEnd() + "]";
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int counter = 0;
        Metting meet = new Metting(1,2);

        int n = sc.nextInt();
        Metting[] arr = new Metting[n];
        meet = arr[0];
        for (int i = 0; i < n; i++) {
            arr[i] = new Metting(sc.nextInt(), sc.nextInt());
        }
        int maxc = -1;
        for (int i = 0; i < n; i++) {
            counter = 0;
            for (int j = i; j < n; j++) {
                if (arr[i].getEnd() == arr[j].getEnd() && arr[i].getStart() == arr[j].getStart()) {
                    counter++;
                }
            }
            if (maxc < counter) {
                maxc = counter;
            }
        }


        System.out.println(maxc);
    }
}