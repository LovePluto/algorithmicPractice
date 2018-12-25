package algorithmicPractice.common;

/**
 * 八皇后问题
 */
public class Queen8 {

    public static int[] result = new int[8];
    private static int count = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 8; i++) {
            cal8queens(i);
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(count);
    }

    public static void cal8queens(int row) {
        if (row == 8) {
            printQueens(result);
            count++;
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (isOk(row, col)) {
                result[row] = col;
                cal8queens(row + 1);
            }
        }
    }

    public static boolean isOk(int row, int column) {
        int left = column - 1;
        int right = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (left >= 0 && result[i] == left) {
                return false;
            }
            if (right < 8 && result[i] == right) {
                return false;
            }
            left--;
            right++;

        }
        return true;
    }

    public static void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (result[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


}
