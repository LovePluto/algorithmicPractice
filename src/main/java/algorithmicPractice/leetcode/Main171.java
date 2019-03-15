package algorithmicPractice.leetcode;

/**
 * 174. 地下城游戏
 * <p>
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class Main171 {

    public static void main(String[] args) {

        Main171 main171 = new Main171();
        int[][] a = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        System.out.println(main171.calculateMinimumHP(a));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int x = dungeon.length;
        int y = dungeon[0].length;
        int[][] dp = new int[x][y];
        dp[x - 1][y - 1] = Math.max(1, 1 - dungeon[x - 1][y - 1]);
        for (int i = x - 2; i >= 0; i--) {
            dp[i][y - 1] = Math.max(1, dp[i + 1][y - 1] - dungeon[i][y - 1]);
        }
        for (int i = y - 2; i >= 0; i--) {
            dp[x - 1][i] = Math.max(1, dp[x - 1][i + 1] - dungeon[x - 1][i]);
        }
        for (int i = x - 2; i >= 0; i--) {
            for (int j = y - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
