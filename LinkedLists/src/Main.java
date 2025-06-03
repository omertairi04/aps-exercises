//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String [] arr = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.next();
//        }
//
//        int newVal = sc.nextInt();
//        sc.close();
//
//        if (arr.length == 1) {
//            System.out.println(arr[0]);
//        } else {
//            System.out.print(arr[0] + "->");
//            for (int i = 1; i < n - 1; i++) {
//                System.out.print(arr[i] + "->");
//            }
//            System.out.println(arr[n - 1]);
//        }
//
//
//        SLL<String> ll = new SLL<String>();
//        if(arr[0].length() > newVal) {
//            ll.insert("Outlier");
//            ll.insertLast(arr[0]);
//        } else {
//            ll.insertFirst(arr[0]);
//        }
//        for (int i = 1; i < n; i++) {
//            if (arr[i].length() > newVal) {
//                ll.insertLast("Outlier");
//            }
//            String insertStr = (arr[i]);
//            ll.insertLast(insertStr);
//        }
//
//        System.out.println(ll);
//
//
//    }
//}



import java.util.Scanner;

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

    public static void insertionSort(Metting[] metting) {
        for (int i=1; i<metting.length; i++) {
            Metting temp = metting[i];
            int j = i-1;
            while (j>=0 && temp.getStart() <= metting[j].getStart()) {
                metting[j+1] = metting[j];
                j--;
            }
            metting[j+1] = temp;
        }
    }

    public static boolean verify(Metting[] metting) {

        for (int i=1; i<metting.length - 1; i++) {
            int m1 = metting[i-1].getEnd();
            int m2 = metting[i].getStart();

            if (m1 > m2) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int counter = 0;
        int n = sc.nextInt();
        Metting[] arr = new Metting[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Metting(sc.nextInt(), sc.nextInt());
        }

        insertionSort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }

        boolean result = verify(arr);
        System.out.println("RESULT: " + result);


    }
}