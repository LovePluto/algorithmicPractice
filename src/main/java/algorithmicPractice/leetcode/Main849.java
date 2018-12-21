package algorithmicPractice.leetcode;

/**
 * 849. 到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * <p>
 * 至少有一个空座位，且至少有一人坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 提示：
 * <p>
 * 1 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 */
public class Main849 {
    public static void main(String[] args) throws Exception {

        int[] a = new int[]{1, 0, 0, 0, 1, 0, 1};
        int[] a3 = new int[]{1, 0, 0, 0, 0, 1, 0, 1};
        int[] a1 = new int[]{1, 0, 0, 0};
        int[] a2 = new int[]{0, 0, 0, 1};
        System.out.println(maxDistToClosest(a));
    }

    public static int maxDistToClosest(int[] seats) {
        int max = 0;
        int temp = 0;
        boolean tag = false;
        for (int i = 0; i < seats.length; i++) {
            if (i == 0 && seats[0] == 0) {
                tag = true;
            }
            if (seats[i] == 0) {
                temp++;
            } else {
                if (tag) {
                    max = temp;
                } else if (temp > 0) {
                    max = Math.max(max, (temp + 1) / 2);
                }
                tag = false;
                temp = 0;
            }
            if (i == seats.length - 1 && seats[seats.length - 1] == 0) {
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
