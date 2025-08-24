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
        CBHT<String,Integer> loggedAfter = new CBHT<>(n);
        CBHT<String, Person> earliest = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Person p = new Person(sc.next(), sc.next(), sc.nextInt(), sc.next(),sc.next(),sc.next(),sc.nextInt());
            table.insert(p, true);
            String[] parts = p.time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);

            SLLNode<MapEntry<String, Integer>> howMany = loggedAfter.search(p.city);
            SLLNode<MapEntry<String, Person>> mostEarly = earliest.search(p.city);

            if (howMany == null) {
                if (hours == 11 && minutes > 45 ) {
                    loggedAfter.insert(p.city, 1);
                    earliest.insert(p.city, p);
                } else if (hours > 11) {
                    loggedAfter.insert(p.city, 1);
                    earliest.insert(p.city,p);
                }
            } else if (hours > 11) {
                loggedAfter.insert(p.city, howMany.element.value+1);
                if (mostEarly != null) {
                    String[] tokens = mostEarly.element.value.time.split(":");
                    int h = Integer.parseInt(tokens[0]);
                    int mins = Integer.parseInt(tokens[1]);

                    if (hours < h) earliest.insert(p.city, p);
                    else if (hours == h && minutes <= mins)
                        earliest.insert(p.city, p);
                }
            }
        }

        int m = sc.nextInt();
        sc.nextLine();

        for (int i=0;i<m;i++) {
            Person p = new Person(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt());
            SLLNode<MapEntry<String,Integer>> cities = loggedAfter.search(p.city);
            SLLNode<MapEntry<String, Person>> nodeEarlies = earliest.search(p.city);

            if (nodeEarlies != null && cities != null ){
                System.out.println("City: " + p.city + " has the following number of customers:\n" + cities.element.value);
                System.out.println("The user who logged on earliest after noon from that city is:");
                System.out.println(nodeEarlies.element.value.name + " " + nodeEarlies.element.value.lN + " with salary " + nodeEarlies.element.value.budget + " from address " + nodeEarlies.element.value.ip + " who logged in at " + nodeEarlies.element.value.time);
                System.out.println();

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
