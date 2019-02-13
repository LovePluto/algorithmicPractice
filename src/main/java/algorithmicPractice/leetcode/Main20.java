package algorithmicPractice.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Main20 {

    public static void main(String[] args) throws Exception {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            char temp = s.charAt(i);
            char c;
            switch (temp) {
                case '{':
                case '[':
                case '(':
                    stack.push(temp);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    c = stack.pop();
                    if (c != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    c = stack.pop();
                    if (c != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    c = stack.pop();
                    if (c != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            ++i;
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
