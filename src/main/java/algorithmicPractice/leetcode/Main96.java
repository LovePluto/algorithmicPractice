package algorithmicPractice.leetcode;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 思路：
 * 树分三部分：根，左子树，右子树
 * 根固定占一个节点，左子树占 k 个节点，右子树占 n-k-1 个节点
 * 组合数：k * (n-k-1) 就是答案
 * k 的值从 0 到 n-1
 * <p>
 * 放弃递归，很容易就爆栈了
 */
public class Main96 {
    public static void main(String[] args) throws Exception {

        System.out.println(numTrees(3));
    }

    public static int[] dp;

    //算法能过，需要一点点技巧
    public static int numTrees(int n) {
        if (n < 3) {
            return n;
        }
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
