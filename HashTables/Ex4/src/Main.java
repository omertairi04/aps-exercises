import java.util.*;

class Person {
    String name;
    String lN;
    int budget;
    String ip;
    String time;
    String city;
    int price;

    public Person(String name, String lN, int budget, String ip, String time, String city, int price) {
        this.name = name;
        this.lN = lN;
        this.budget = budget;
        this.ip = ip;
        this.time = time;
        this.city = city;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<Person, Boolean> table = new CBHT<>(n);
        CBHT<String, Integer> enoughBudget = new CBHT<>(n);
        CBHT<String, Person> mostAmount = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Person p = new Person(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt());
            table.insert(p, true);

            SLLNode<MapEntry<String, Integer>> howMany = enoughBudget.search(p.ip);
            SLLNode<MapEntry<String, Person>> mostPayed = mostAmount.search(p.ip);

            if (howMany == null) {
                if (p.budget >= p.price) enoughBudget.insert(p.ip, 1);
                mostAmount.insert(p.ip, p);
            } else {
                if (p.budget >= p.price) {
                    if (mostPayed == null || p.price > mostPayed.element.value.price) {
                        mostAmount.insert(p.ip, p);
                    }
                    enoughBudget.insert(p.ip, howMany.element.value + 1);
                }
            }
        }
        int M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            Person p = new Person(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt());
            SLLNode<MapEntry<String, Person>> nodeMost = mostAmount.search(p.ip);
            SLLNode<MapEntry<String, Integer>> ips = enoughBudget.search(p.ip);
/*
IP network: 10.73.112 has the following number of users:
2
The user who spent the most from that network is:
Viktor Jovev with salary 2200 from address 10.73.112.79 who spent 1800

 */
            if (nodeMost != null && ips != null) {
                System.out.println("IP network:" + p.ip + " has the following number of users:\n" + ips.element.value);
                System.out.println("The user who spent the most from that network is:");
                System.out.println(nodeMost.element.value.name + " " + nodeMost.element.value.name
                        + " with salary " + nodeMost.element.value.budget + " from address "
                        + nodeMost.element.value.ip + " who spent " + nodeMost.element.value.price);
            }

        }
    }
}

class CBHT<K, E> {
    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is equal to targetKey.
        // Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(targetKey)) return currNode;
            else currNode = currNode.succ;
        }
        return null;
    }

    public void insert(K key, E val) {
        // Insert the entry <key, val> into this CBHT.
        // If entry with same key exists, overwrite it.
        MapEntry<K, E> newEntry = new MapEntry<>(key, val);
        int b = hash(key);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                // Make newEntry replace the existing entry ...
                currNode.element = newEntry;
                return;
            } else currNode = currNode.succ;
        }
        // Insert newEntry at the front of the SLL in bucket b ...
        buckets[b] = new SLLNode<>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        SLLNode<MapEntry<K, E>> predNode = null, currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                if (predNode == null) buckets[b] = currNode.succ;
                else predNode.succ = currNode.succ;
                return;
            } else {
                predNode = currNode;
                currNode = currNode.succ;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + " ";
                curr = curr.succ;
            }
            temp += "\n";
        }
        return temp;
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

class MapEntry<K, E> {
    // Each MapEntry object is a pair consisting of a key
    // and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}
