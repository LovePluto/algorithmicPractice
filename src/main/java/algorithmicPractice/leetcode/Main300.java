package algorithmicPractice.leetcode;

/**
 * 300. 最长上升子序列
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * <p>
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 两轮搜索，每次搜索前面数字比上千数字小的数
 */
public class Main300 {

    public static void main(String[] args) throws Exception {
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] array1 = {4, 10, 4, 3, 8, 9};
        int[] array2 = {9, 8, 7, 6, 5, 4};
        System.out.println(lengthOfLIS(array1));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;

        int length = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > length) {
                length = dp[i];
            }
        }
        return length;
    }
}
