package algorithmicPractice.leetcode;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Main322 {

    public static int maxValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        int[] array = {1, 2, 5};
        System.out.println(coinChange(array, 11));
    }

    public static int[][] temp;

    public static int coinChange(int[] coins, int amount) {
        temp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                temp[i][j] = -1;
            }
        }
        for (int i = 0; i < coins.length; i++) {
            temp[i][0] = 0;
        }
        for (int i = 1; i < amount + 1; i++) {
            if (i % coins[0] == 0) {
                temp[0][i] = i / coins[0];
            } else {
                temp[0][i] = maxValue;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    temp[i][j] = Math.min(temp[i][j - coins[i]] + 1, temp[i - 1][j]);
                } else {
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }
        return temp[coins.length - 1][amount] < maxValue ? temp[coins.length - 1][amount] : -1;
    }
}
