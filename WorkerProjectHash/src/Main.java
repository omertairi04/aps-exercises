// Следните класи веќе се импортирани, не е дозволено копирање на класи овде, директно користејте ги како кога се достапни во други локални фајлови:

// CBHT, OBHT, MapEntry, SLLNode веќе се импортирани
import java.util.Scanner;

// Овде креирајте ги помошните класи за клуч и вредност
// Исполнете ги барањата од текстот за toString методите
// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
// hashCode и equals методи

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    K key;
    E value;

    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}


class Person implements Comparable<Person> {
    // поставете ги потребните полиња овде
    String name;
    int age;
    Project project;

    // имплементирајте соодветен конструктор


    public Person(String name, int age, Project project) {
        this.name = name;
        this.age = age;
        this.project = project;
    }

    @Override
    public String toString() {
        return "<" + name + ", " + age + ">";
    }



    // имплементирајте ги следните два методи за да работи табелата правилно
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
    @Override
    public int hashCode() {
        var name = this.name.charAt(0);
        var ascii = (int) name;
        return age * ascii;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

class Project implements Comparable<Project> {
    int workingTime;
    int payPerHour;
    int salary;

    public Project(int wokringTime, int payPerHour) {
        this.workingTime = wokringTime;
        this.payPerHour = payPerHour;
        this.salary = wokringTime * payPerHour;
    }

    @Override
    public String toString() {
        return "<" + workingTime + ", " + payPerHour + ">";
    }

    public int getWokringTime() {
        return workingTime;
    }

    public void setWokringTime(int wokringTime) {
        this.workingTime = wokringTime;
    }

    public int getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(int payPerHour) {
        this.payPerHour = payPerHour;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Project o) {
        return salary - o.salary;
    }
}

public class Main {
    public static void main(String[] args) {
        // Креирајте ја табелата според барањата
        CBHT<Person,Project> table = new CBHT<Person,Project>(10);
        // Прочитајте ги податоците од влезот и пополнете ја табелата
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for  (int i = 0; i < n; i++) {
            var line = sc.nextLine();
            var splitted =  line.split(" ");
            var project = new Project(Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]));
            Person person = new Person(splitted[0],Integer.parseInt(splitted[1]), project);

            SLLNode<MapEntry<Person, Project>> existingPerson = table.search(person);
            if (existingPerson != null) {
                if (person.project.salary > existingPerson.element.value.salary) {
                    existingPerson.element.value = project;
                }
            } else
                table.insert(person,project);


        }
        // workers should select the project with most pay





        // отпечатете ја вашата табела
        System.out.println(table);
    }
}

