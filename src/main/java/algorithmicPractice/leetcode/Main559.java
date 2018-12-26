package algorithmicPractice.leetcode;

import java.util.List;

/**
 * 559.N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
public class Main559 {

    public static int max = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return solve(root);
    }

    public int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (Node node : root.children) {
            count = Math.max(count, solve(node));
        }
        return count += 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
