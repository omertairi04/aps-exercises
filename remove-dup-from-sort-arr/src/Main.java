public class Main {
    public int removeDuplicates(int[] nums) {
        int k=0;
        int newArray[]=new int[nums.length];

        for (int i=0;i<nums.length;i++){
            
        }

    }

    /*
    k = 0
    newArray = [];
    if nums[0] is in newArray => no it isn't thus newArray[1];
    if nums[1] is in newArray => yes it is thus continue
    if nums[2] is in newArray => no it isn't thus newArray[1,2];
    k = newArray.length

    */

    public static void main(String[] args) {

        int[] array = {1,1,2};
        int result = new Main().removeDuplicates(array);
        System.out.println(result);


    }
}