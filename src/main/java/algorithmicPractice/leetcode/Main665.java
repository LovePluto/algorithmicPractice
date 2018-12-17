package algorithmicPractice.leetcode;

/**
 * 665. 非递减数列
 * <p>
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * 说明:  n 的范围为 [1, 10,000]。
 */
public class Main665 {

    public static void main(String[] args) throws Exception {

        int[] arr = {4, 2, 1};
        int[] arr1 = {4, 2, 3};
        int[] arr2 = {3, 4, 2, 3};

        System.out.println(checkPossibility(arr));
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int pre = 0;
        int now = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                pre = nums[i - 1];
                now = nums[i];
                index = i;
                nums[i - 1] = pre;
                nums[i] = pre;
                break;
            }
        }
        boolean perB = true;
        boolean nowB = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                perB = false;
                nums[index - 1] = now;
                nums[index] = now;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                nowB = false;
                break;
            }
        }
        return perB || nowB;
    }
}
