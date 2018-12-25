package algorithmicPractice.common;

/**
 * KMP 算法
 */
public class KMP {
    public static void main(String[] args) {

        String s = "ddfsadfsadfaslf;ksdafjklsad;f";
        s.contains("cc");
        System.out.println(find("dfsafsdafsadfsafsdafsad", "daf"));

    }

    public static boolean find(String a, String b) {
        int[] next = getNext(b.toCharArray());
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            while (j > 0 && a.charAt(i) != b.charAt(j)) {
                j = next[j - 1] + 1;
            }
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            if (j == b.length()) {
                return true;
            }
        }
        return false;
    }

    private static int[] getNext(char[] b) {
        int[] next = new int[b.length];
        int k = -1;
        next[0] = -1;
        for (int i = 1; i < b.length; i++) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
}
