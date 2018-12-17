package algorithmicPractice.leetcode;

/**
 * 643. 子数组最大平均数 I
 * <p>
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class Main643 {

    public static void main(String[] args) throws Exception {
        int arr[] = {1, 12, -5, -6, 50, 3};
        int n = 4;

        int arr1[] = {9, 7, 3, 5, 6, 2, 0, 8, 1, 9};
        int n1 = 6;
        System.out.println(findMaxAverage(arr1, n1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        double temp = 0;
        for (int i = 0; i < k; ++i) {
            temp += nums[i];
        }
        double res = temp / k;
        if (nums.length == k) {
            return res;
        }
        for (int i = k; i < nums.length; ++i) {
            temp = temp - nums[i - k] + nums[i];
            res = Math.max(res, temp / (double) k);
        }
        return res;
    }
}
