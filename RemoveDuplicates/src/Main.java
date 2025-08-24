import java.util.*;
public class Main {


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        boolean res = isPalindrome("A man, a plan, a canal: Panama");

        System.out.println(res);
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        s = s.replace(",", "");
        s = s.replace(":", "");
        s = s.replace(" ", "");
        s = s.toLowerCase();
        System.out.println(s);
        int i=0 , j=s.length()-1;
        while (j > 0) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if (c1 != c2) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static  int removeElement(int[] nums, int val) {
        int[] toReturn = new int[nums.length];

        int k = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != val) {
                toReturn[k] = nums[i];
                k++;
            }
        }

        System.out.println(Arrays.toString(toReturn));
        return k;
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int number = nums[0];
        ArrayList<String> newNums = new ArrayList<String>();
        Set<Integer> set = new HashSet<>();

        for (int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }

        System.out.println(set.toString());

        for (int value : set) {
            System.out.println("VALUE: " + value);
            newNums.add(String.valueOf(value));
        }

        System.out.println(newNums.toString());

        for (int i=set.size(); i < nums.length; i++) {
            newNums.add("_");
        }

        System.out.println(newNums.toString());

        return set.size();

    }
}