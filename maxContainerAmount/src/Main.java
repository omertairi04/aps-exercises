// https://leetcode.com/problems/container-with-most-water/?envType=problem-list-v2&envId=array


class Solution {
    public int maxArea(int[] height) {
        int firstPointer = 0;
        int lastPointer = height.length - 1;
        int maxArea = 0;
        while (firstPointer < lastPointer) {
            if (height[firstPointer] < height[lastPointer]) {
                maxArea = Math.max(maxArea, height[firstPointer] * (lastPointer - firstPointer));
                firstPointer++;
            } else {
                maxArea = Math.max(maxArea, height[lastPointer] * (lastPointer - firstPointer));
                lastPointer--;
            }
        }
        return maxArea;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(res);
    }
}


