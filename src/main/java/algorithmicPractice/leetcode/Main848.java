package algorithmicPractice.leetcode;

/**
 * 848. 字母移位
 * 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
 * <p>
 * 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
 * <p>
 * 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
 * <p>
 * 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
 * <p>
 * 返回将所有这些移位都应用到 S 后最终得到的字符串。
 * <p>
 * 示例：
 * <p>
 * 输入：S = "abc", shifts = [3,5,9]
 * 输出："rpl"
 * 解释：
 * 我们以 "abc" 开始。
 * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
 * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
 * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
 * 提示：
 * <p>
 * 1 <= S.length = shifts.length <= 20000
 * 0 <= shifts[i] <= 10 ^ 9
 */
public class Main848 {
    public static void main(String[] args) throws Exception {
        String s = "abc";
        int[] shifts = new int[]{3, 5, 9};

        String s1 = "z";
        int[] shifts1 = new int[]{52};

        String s2 = "bad";
        int[] shifts2 = new int[]{10, 20, 30};
        System.out.println(shiftingLetters(s2, shifts2));
    }

    public static String shiftingLetters(String S, int[] shifts) {
        char[] result = S.toCharArray();
        long[] temp = new long[shifts.length];
        temp[shifts.length - 1] = shifts[shifts.length - 1];
        for (int i = shifts.length - 2; i >= 0; --i) {
            temp[i] = temp[i + 1] + shifts[i];
        }
        for (int i = 0; i < shifts.length; i++) {
            if (temp[i] > 26) {
                temp[i] = temp[i] % 26;
            }
            result[i] = (char) (result[i] + temp[i]);
            if (result[i] > 'z') {
                result[i] = (char) (result[i] - 26);
            }
        }
        return new String(result);
    }
}
