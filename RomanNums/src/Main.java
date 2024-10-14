public class Main {
    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        int s_Value = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                if (s.charAt(i - 1) == 'C') {
                    s_Value += 900;
                } else {
                    s_Value += 1000;
                }
            } else if (s.charAt(i) == 'D') {
                if (s.charAt(i - 1) == 'C') {
                    s_Value += 400;
                } else {
                    s_Value += 500;
                }
            } else if (s.charAt(i) == 'L') {
                if (s.charAt(i - 1) == 'X') {
                    s_Value += 40;
                } else {
                    s_Value += 50;
                }
            } else if (s.charAt(i) == 'C') {
                if (s.charAt(i - 1) == 'X') {
                    s_Value += 90;
                } else {
                    s_Value += 100;
                }
            } else if (s.charAt(i) == 'V') {
                if (s.charAt(i - 1) == 'I') {
                    s_Value += 4;
                } else {
                    s_Value += 5;
                }
            } else if (s.charAt(i) == 'X') {
                if (s.charAt(i - 1) == 'I') {
                    s_Value += 9;
                } else {
                    s_Value += 10;
                }
            } else if (s.charAt(i) == 'I') {
                s_Value += 1;
            }
        }
        return s_Value;

    }
}
