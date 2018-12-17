package algorithmicPractice.leetcode;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 这道题的难度在于，随着循环的增加，初试的状态会修改
 * 思路从二维数组到一维数组的变化，初试题目是一维数组
 * 就尽量用一维数组的状态表示，不要用二维数组储存中间计算过程
 */
public class Main53 {

    public static void main(String[] args) throws Exception {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] array1 = {-1, -2};
        int[] array2 = {-2, -1};
        int[] array3 = {-2, -3, -1};
        int[] array4 = {2, -1, 1, 1};
        int[] array5 = {-2147483647};
        System.out.println(maxSubArray(array1));
    }

    public static int[] dp;
    public static int max = 0;


    public static int maxSubArray(int[] nums) {
        //长度 1 就直接返回，没有必要计算
        if (nums.length == 1) {
            return nums[0];
        }
        max = nums[0];
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
