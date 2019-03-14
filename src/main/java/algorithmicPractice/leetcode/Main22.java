package algorithmicPractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 内存消耗稳定在 38M 左右，运行速度稳定变快
 */
public class Main22 {

    public static void main(String[] args) {
        Main22 main22 = new Main22();
        System.out.println(main22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return null;
        }
        List<String> list = new ArrayList<>();
        char[] chars = new char[n * 2];
//        StringBuilder sb = new StringBuilder();
//        solve(list, 0, 0, n, "");
//        solve2(list, 0, 0, n, sb);
        solve3(list, 0, 0, n, chars, 0);
        return list;
    }


    public void solve3(List<String> list, int left, int right, int n, char[] chars, int index) {
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            list.add(new String(chars));
            return;
        }
        if (left >= right) {
            chars[index] = '(';
            solve3(list, left + 1, right, n, chars, index + 1);
            chars[index] = ')';
            solve3(list, left, right + 1, n, chars, index + 1);
        }
    }

    public void solve2(List<String> list, int left, int right, int n, StringBuilder s) {
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            list.add(s.toString());
            return;
        }
        if (left >= right) {
            solve2(list, left + 1, right, n, s.append("("));
            s.deleteCharAt(s.length() - 1);
            solve2(list, left, right + 1, n, s.append(")"));
            s.deleteCharAt(s.length() - 1);
        }
    }

    public void solve(List<String> list, int left, int right, int n, String s) {
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left >= right) {
            solve(list, left + 1, right, n, s + "(");
            solve(list, left, right + 1, n, s + ")");
        }
    }

}
