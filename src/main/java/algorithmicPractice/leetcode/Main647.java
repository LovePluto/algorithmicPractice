package algorithmicPractice.leetcode;

/**
 * 647. 回文子串
 * <p>
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * <p>
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 注意:
 * <p>
 * 输入的字符串长度不会超过1000。
 */
public class Main647 {
    public static void main(String[] args) throws Exception {
        String s = "abc";
        String s1 = "aaa";
        System.out.println(countSubstrings(s1));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        count += s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (solve(s, i, j)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static boolean solve(String s, int i, int j) {
        while (i < j) {
            if (!(s.charAt(i) == s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
