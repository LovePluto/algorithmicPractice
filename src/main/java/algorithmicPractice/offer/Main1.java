package algorithmicPractice.offer;

import algorithmicPractice.leetcode.Main83;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 二维数组中的查找
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Main1 {

    public static void main(String[] args) throws Exception {

    }

    public static boolean Find(int target, int[][] array) {
        if (array.length < 1) {
            return false;
        }
        if (array[0].length < 1) {
            return false;
        }
        int i = 0;
        int j = array.length - 1;
        while (i < array[0].length && j >= 0) {
            if (array[j][i] == target) {
                return true;
            }
            if (array[j][i] < target) {
                i++;
                continue;
            }
            if (array[j][i] > target) {
                j--;
                continue;
            }
        }
        return false;
    }

    public boolean Find1(int target, int[][] array) {
        if (array.length < 0) {
            return false;
        }
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j < array[0].length) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] > target) {
                i--;

            } else {
                j++;
            }
        }
        return false;
    }
}
