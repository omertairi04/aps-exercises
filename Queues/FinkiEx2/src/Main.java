import java.util.*;

class Student {
    String name;
    String science;
    String scienceF;
    String history;

    public Student(String name, String science, String scienceF, String history) {
        this.name = name;
        this.science = science;
        this.scienceF = scienceF;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public String getScienceF() {
        return scienceF;
    }

    public void setScienceF(String scienceF) {
        this.scienceF = scienceF;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", science='" + science + '\'' +
                ", scienceF='" + scienceF + '\'' +
                ", history='" + history + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {

        Queue<Student> queueScience = new LinkedList<Student>();
        Queue<Student> queueScienceF = new LinkedList<Student>();
        Queue<Student> queueHistory = new LinkedList<Student>();

        ArrayList<Student> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() - 1;
        sc.nextLine();

        while (n-- >= 0) {
            String name = sc.nextLine();
            String science = sc.nextLine();
            String sF = sc.nextLine();
            String h = sc.nextLine();
            Student newStudent = new Student(name, science, sF, h);
            students.add(newStudent);
//            System.out.println(n);
        }

        for (int i = 0; i < students.size(); i++) {
            Student curr = students.get(i);

            if (curr.getScience().equals("1")) {
                queueScience.offer(curr);
            } else if (!curr.getScience().equals("1")
                    && curr.getScienceF().equals("1")) queueScienceF.offer(curr);
            else if (!curr.getScience().equals("1")
                    && !curr.getScienceF().equals("1")
                    && curr.getHistory().equals("1")) queueHistory.offer(curr);
            else {
                System.out.println(curr.getName());
            }
        }

        while (!queueScience.isEmpty()) {
            Student firstS = queueScience.poll();
            if (firstS.getScienceF().equals("1")) {
                queueScienceF.offer(firstS);
            } else if (!firstS.getScienceF().equals("1")
                    && firstS.getHistory().equals("1")) {
                queueHistory.offer(firstS);
            } else {
                System.out.println(firstS.name);
            }
        }

        while (!queueScienceF.isEmpty()) {
            Student firstS = queueScienceF.poll();
            if (firstS.getHistory().equals("1")) {
                queueHistory.offer(firstS);
            } else {
                System.out.println(firstS.name);
            }
        }

        while (!queueHistory.isEmpty()) {
            Student firstS = queueHistory.poll();
            System.out.println(firstS.name);
        }

    }
}