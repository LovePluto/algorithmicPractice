package algorithmicPractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 如果用 O(n) 的额外空间，可以考虑滚动数组形式
 * <p>
 * 直接全部搜索一遍
 */
public class Main120 {

    public static void main(String[] args) throws Exception {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(minimumTotal(lists));
    }

    public static int[][] dp;

    public static int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size() < 1) {
            return 0;
        }
        if (triangle.get(0).size() < 1) {
            return 0;
        }
        int deep = triangle.size();
        int index = triangle.get(deep - 1).size();
        dp = new int[deep][index];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + list.get(0);
            dp[i][list.size() - 1] = dp[i - 1][list.size() - 2] + list.get(list.size() - 1);
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + list.get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            min = Math.min(min, dp[deep - 1][i]);
        }
        return min;
    }
}
