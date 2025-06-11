import java.util.*;

class Student {
    String name;
    int science;   // 1 if interested in Science
    int sF;        // 1 if interested in Sci-Fi
    int history;   // 1 if interested in History

    public Student(String name, String science, String sF, String history) {
        this.name = name;
        this.science = Integer.parseInt(science);
        this.sF = Integer.parseInt(sF);
        this.history = Integer.parseInt(history);
    }

    public boolean hasScience() {
        return science == 1;
    }

    public boolean hasSF() {
        return sF == 1;
    }

    public boolean hasHistory() {
        return history == 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Queue<Student> q1 = new LinkedList<>(); // Science
        Queue<Student> q2 = new LinkedList<>(); // Sci-Fi
        Queue<Student> q3 = new LinkedList<>(); // History
        Queue<String> output = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String sci = sc.nextLine();
            String sf = sc.nextLine();
            String hist = sc.nextLine();

            Student s = new Student(name, sci, sf, hist);

            // Only assign once based on priority
            if (s.hasScience()) {
                q1.offer(s);
            } else if (s.hasSF()) {
                q2.offer(s);
            } else if (s.hasHistory()) {
                q3.offer(s);
            }
        }

        while (!q1.isEmpty() || !q2.isEmpty() || !q3.isEmpty()) {
            int count = 0;

            // Process up to 2 from Science
            while (!q1.isEmpty() && count < 2) {
                Student s = q1.poll();
                if (s.hasSF()) {
                    q2.offer(s);
                } else if (s.hasHistory()) {
                    q3.offer(s);
                } else {
                    output.offer(s.name);
                }
                count++;
            }

            // Process 1 from Sci-Fi
            if (!q2.isEmpty()) {
                Student s = q2.poll();
                if (s.hasHistory()) {
                    q3.offer(s);
                } else {
                    output.offer(s.name);
                }
            }

            // Process up to 2 from History
            count = 0;
            while (!q3.isEmpty() && count < 2) {
                Student s = q3.poll();
                output.offer(s.name);
                count++;
            }
        }

        // Print results
        while (!output.isEmpty()) {
            System.out.println(output.poll());
        }
    }
}
