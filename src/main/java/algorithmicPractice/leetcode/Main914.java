package algorithmicPractice.leetcode;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Main914 {


    public static void main(String[] args) {
        Main914 main914 = new Main914();
        int[] a = {2, 1};
        int[] a1 = {3, 5, 5};
        int[] a2 = {0, 3, 2, 1};
        int[] a3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(main914.validMountainArray(a3));
    }

    public boolean validMountainArray(int[] A) {
        boolean res = true;
        if (A == null || A.length < 3) {
            return false;
        }
        boolean tag = false;//递增为 false，递减为 true
        for (int i = 1; i < A.length; ++i) {
            if (A[i] - A[i - 1] < 0) {
                if (i == 1) {
                    res = false;
                    break;
                }
                if (!tag && i != A.length) {
                    tag = true;
                }
            } else {
                if (tag) {
                    res = false;
                    break;
                }
            }
        }
        return res && tag;
    }
}
