package algorithmicPractice.leetcode;

/**
 * 413. 等差数列划分
 * <p>
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，以下数列为等差数列:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * <p>
 * 以下数列不是等差数列。
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * <p>
 * <p>
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * <p>
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * <p>
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * <p>
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */
public class Main413 {
    public static void main(String[] args) throws Exception {

        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {7, 7, 7, 7};
        int[] arr3 = {3, -1, -5, -9};
        int[] arr4 = {1, 1, 2, 5, 7};
        int[] arr5 = {1, 2, 3, 4, 5, 6};
        int[] arr6 = {1, 2, 3, 5, 7, 8};
        System.out.println(numberOfArithmeticSlices(arr));
    }


    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int res = 0;
        int count = 2;
        int dp[] = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            dp[i] = i * (i + 1) / 2;
        }
        int pre = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            int temp = A[i] - A[i - 1];
            if (temp == pre) {
                count++;
            } else {
                res += dp[count - 2];
                pre = temp;
                count = 2;
            }
        }
        if (count > 2) {
            res += dp[count - 2];
        }
        return res;
    }
}
