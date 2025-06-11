import java.util.*;

class Student {
    String name;
    String q1;
    String q2;
    String q3;

    public Student(String name, String q1, String q2, String q3) {
        this.name = name;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    public String getName() {
        return name;
    }

    public String getQ1() {
        return q1;
    }

    public String getQ2() {
        return q2;
    }

    public String getQ3() {
        return q3;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Student> q1 = new LinkedList<>();
        Queue<Student> q2 = new LinkedList<>();
        Queue<Student> q3 = new LinkedList<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();

            Student s = new Student(name,s1,s2,s3);

            if (s.getQ1().equals("1")) q1.offer(s);
            else if (s.getQ2().equals("1")) q2.offer(s);
            else if (s.getQ3().equals("1")) q3.offer(s);
        }

        while (!q1.isEmpty() || !q2.isEmpty() || !q3.isEmpty()) {
            int counter = 0;
            while (!q1.isEmpty() && counter < 2) {
                Student first = q1.poll();
                if (first.getQ2().equals("1")) q2.offer(first);
                else if (first.getQ3().equals("1")) q3.offer(first);
                else System.out.println(first.name);
                counter++;
            }

            counter = 0;
            while(!q2.isEmpty() && counter < 3) {
                Student first = q2.poll();
                if (first.getQ3().equals("1")) q3.offer(first);
                else System.out.println(first.name);
                counter++;
            }

            if (!q3.isEmpty()) {
                Student first = q3.poll();
                System.out.println(first.name);
            }

        }

    }
}