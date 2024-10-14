public class Main {
    public static void main(String[] args) {
        boolean res = isPalindrome(121);
        System.out.println(res);
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString().equals(str);
    }
}