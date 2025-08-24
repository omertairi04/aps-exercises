import java.util.*;

class Person implements Comparable<Person> {
    String name;
    int age; // Changed to int

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "<" + name + ", " + age + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return age * (int) name.charAt(0); // Hash function as specified
    }

    @Override
    public int compareTo(Person other) {
        // Compare by name first, then age (arbitrary but consistent ordering)
        int nameCompare = name.compareTo(other.name);
        if (nameCompare != 0) return nameCompare;
        return Integer.compare(age, other.age);
    }
}

class Project {
    int workingTime; // Changed to int
    int payPerHour;  // Changed to int

    public Project(int workingTime, int payPerHour) {
        this.workingTime = workingTime;
        this.payPerHour = payPerHour;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public int getPayPerHour() {
        return payPerHour;
    }

    public int getSalary() {
        return workingTime * payPerHour; // Calculate total salary
    }

    @Override
    public String toString() {
        return "<" + workingTime + ", " + payPerHour + ">";
    }
}

public class Ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<Person, Project> table = new CBHT<>(10);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String name = parts[0];
            int age = Integer.parseInt(parts[1]); // Parse age as int
            int workingTime = Integer.parseInt(parts[2]); // Parse as int
            int payPerHour = Integer.parseInt(parts[3]); // Parse as int
            Person person = new Person(name,age);
            Project project = new Project(workingTime,payPerHour);
            SLLNode<MapEntry<Person, Project>> node = table.search(person);
            if (node == null) table.insert(person,project);
            else {
                Project nodeProject = node.element.value;
                if (project.getSalary() > nodeProject.getSalary()){
                    table.insert(person,project);
                }
            }
        }
        // Print the table
        System.out.println(table);
    }
}