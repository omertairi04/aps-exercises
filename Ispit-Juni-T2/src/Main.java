import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> dokumenti = new ArrayList<>();
        List<String> statusi = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String naredba = scanner.nextLine(); // order
            String[] delovi = naredba.split(" "); // parts

            if (delovi[0].equals("ADD")) {
                String ime = delovi[1];
                int broj = Integer.parseInt(delovi[2]);
                for (int j = 0; j < broj; j++) {
                    dokumenti.add(ime);
                    statusi.add("waiting");
                }
            } else if (delovi[0].equals("STATUS")) {
                System.out.println("Current status:");
                for (int j = 0; j < dokumenti.size(); j++) {
                    System.out.println(dokumenti.get(j) + " " + statusi.get(j));
                }
                System.out.println();
            } else if (delovi[0].equals("PRINT")) {
                int broj = Integer.parseInt(delovi[1]);
                int ispecateni = 0;
                for (int j = 0; j < statusi.size() && ispecateni < broj; j++) {
                    if (statusi.get(j).equals("waiting")) {
                        statusi.set(j, "printed");
                        ispecateni++;
                    }
                }
            }
        }
        scanner.close();
    }
}