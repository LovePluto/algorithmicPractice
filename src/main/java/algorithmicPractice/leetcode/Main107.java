package algorithmicPractice.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 107. 二叉树的层次遍历 II\
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * 在真实的面试中
 */
public class Main107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        solve(lists, 0, root);
        for (int i = 0, j = lists.size() - 1; i < j; i++, j--) {
            List<Integer> temp = lists.get(i);
            lists.set(i, lists.get(j));
            lists.set(j, temp);
        }
        return lists;
    }

    public void solve(List<List<Integer>> lists, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (lists.size() == level) {
            List<Integer> list = new ArrayList();
            list.add(root.val);
            lists.add(list);
        } else {
            lists.get(level).add(root.val);
        }
        solve(lists, level + 1, root.left);
        solve(lists, level + 1, root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
