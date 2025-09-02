import java.util.*;

class Student {
    String name;
    String surname;
    String type;
    String s;
    String sf;
    String h;

    public Student(String name, String surname, String type, String s, String sf, String h) {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.s = s;
        this.sf = sf;
        this.h = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getS() {
        return s;
    }

    public String getSf() {
        return sf;
    }

    public String getH() {
        return h;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}

class CompareTypes implements Comparator<Student> {
    private int getPriority(String type) {
        switch (type.toLowerCase()) {
            case "masters": return 1;
            case "bachelors": return 2;
            case "highschools": return 3;
            default: return 4;
        }
    }
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(getPriority(o1.type), getPriority(o2.type));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String type = sc.nextLine();
            String s = sc.nextLine();
            String sf = sc.nextLine();
            String h = sc.nextLine();

            String[] split = name.split(" ");

            Student student = new Student(split[0], split[1], type, s, sf, h);
            students[i] = student;
        }

        PriorityQueue<Student> science = new PriorityQueue<>(new CompareTypes());
        PriorityQueue<Student> scienceFiction = new PriorityQueue<>(new CompareTypes());
        PriorityQueue<Student> history = new PriorityQueue<>(new CompareTypes());


        for (int i = 0; i < students.length; i++) {
            if (students[i].getS().equals("1")) {
                science.add(students[i]);
            } else if (students[i].getSf().equals("1")) {
                scienceFiction.add(students[i]);
            } else if (students[i].getH().equals("1")) {
                history.add(students[i]);
            } else {
                System.out.println(students[i]);
            }
        }

        if (!science.isEmpty()) {
            for (int i = 0; i <= science.size(); i++) {
                Student f = science.poll();
                if (f.getSf().equals("1")) {
                    scienceFiction.add(f);
                } else if (f.getH().equals("1")) {
                    history.add(f);
                } else {
                    System.out.println(f);
                }
            }
        }

        if (!scienceFiction.isEmpty()) {
            for (int i = 0; i <= scienceFiction.size(); i++) {
                Student f = scienceFiction.poll();
                if (f.getH().equals("1")) {
                    history.add(f);
                } else {
                    System.out.println(f);
                }
            }
        }

        if (!history.isEmpty()) {
            for (int i = 0; i <= history.size(); i++) {
                Student f = history.poll();
                System.out.println(f);
            }
        }

    }
}