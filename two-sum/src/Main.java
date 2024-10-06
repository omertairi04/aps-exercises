public class Main {
    public static int[] twoSum(int[] nums, int target) {
        /*
        arr = [2 , 7, 11, 15] , target = 26
        arr[0] + arr[1] = 9 != 30
        arr[0] + arr[2] = 13 != 30
        arr[0] + arr[3] = 17 != 30
        arr[1] + arr[2] = 18 != 30
        arr[1] + arr[3] = 22 != 30
        arr[2] + arr[3] = 26 == 30
        return [2,3]
         */
        int a = 0, b = 0;
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                int indexSum = 0;
                indexSum += nums[i] + nums[j];
                a = i;
                b = j;
                if (indexSum == target) {
                    System.out.println("NUMBER " + nums[a] + " + " + nums[b] + " is equal to " + target);
                    return new int[]{a, b};
                }
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int array[] = {2,5,5,11};
        int[] res = twoSum(array , 10);
        System.out.print("[" +res[0]+","+res[1]+"]");
    }
}