import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static int count(int N){
        // Vasiot kod tuka
        // total cards: 51;
        // 7 cards rearranges them from top to bottom (1,2,3,...,7) -> (7,6,5,...,1)
        // take 1 card from reversed from top and put it at the bottom, until the end
        return 1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
