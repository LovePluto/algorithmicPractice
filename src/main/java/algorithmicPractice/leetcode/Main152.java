package algorithmicPractice.leetcode;

/**
 * 152. 乘积最大子序列
 * <p>
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Main152 {

    public static void main(String[] args) throws Exception {

        int[] arr = {2, 3, -2, 4};
        int[] arr1 = {-2, 0, -1};
        int[] arr2 = {-2, 3, -4};
        int[] arr3 = {3, -1, 4};
        int[] arr4 = {2, -5, -2, -4, 3};
        int[] arr5 = {-3, 0, 1, -2};
        System.out.println(maxProduct(arr));
    }

    /**
     * 能过，不过可能要超时，这个速度太慢了
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            max = Math.max(temp, max);
            for (int j = i + 1; j < nums.length; j++) {
                temp = temp * nums[j];
                max = Math.max(temp, max);
            }
        }
        return max;
    }
}
