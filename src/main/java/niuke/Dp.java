package niuke;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/18 22:50
 * @Description
 */
public class Dp {
    public static void main(String[] args) {
//        三角形第n层有n个数字取最大值
//        test1();

//        矩阵取最值数问题
//        test2();

//        最长递增子序列
//        test3();

//        背包问题
//        test4();
//        packageTotal();

//      青蛙跳台阶。一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//        System.out.println(JumpFloor1(5));
//        System.out.println(JumpFloor2(5));

//        给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
//        maxLength(new int[]{2,3,4,5});
    }

    /**
     * 找到字符串的最长无重复字符子串
     *
     * @param arr
     * @return
     */
    private static int maxLength(int[] arr) {
        // write code here
//        记录数字最后一次出现的位置。当前索引对应数值index，其值标识当前index开始窗口，滑动窗口
        int[] last = new int[100000];
        //res：最大长度    start：窗口开始的位置
        int res = 0, start = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            start = Math.max(start, last[val]);
            System.out.println(String.format("i:%d  index:%d  start:%d", i, val, start));
            res = Math.max(res, i - start + 1);
            last[val] = i + 1;
        }
        return res;
    }

    //    自底向上型循环求解，时间复杂度为O(n)
    private static int JumpFloor1(int target) {
        int[] num = new int[]{1, 1};
        for (int i = 1; i < target; i++) {
            num[0] = num[0] + num[1];
            num[1] = num[0] - num[1];
        }
        return num[0];
    }

    //    递归，时间复杂度为O(n^2)
    private static int JumpFloor2(int target) {
        if (target <= 2) {
            return target;
        }
        return JumpFloor2(target - 1) + JumpFloor2(target - 2);
    }

    /**
     * 完全背包问题。
     * 物品个数：4，背包容量：7，每行输入：物品重量，价值
     * 4
     * 7
     * 5 3
     * 2 4
     * 4 20
     * 3 5
     * 结果：对应大小从0~7时，可以装的物品价值。[0, 0, 4, 5, 20, 20, 24, 25]
     */
    private static void packageTotal() {
        Scanner scan = new Scanner(System.in);
        //物品个数
        int n = scan.nextInt();
        //M：背包最大容量
        int M = scan.nextInt();
        int[] dp = new int[M + 1];
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            weight[i] = scan.nextInt();
            value[i] = scan.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = weight[i]; j <= M; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println("max：" + dp[dp.length - 1]);
    }

    /**
     * 背包问题
     */
    private static void test4() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int v = scan.nextInt();
        int[] dp = new int[v + 1];
        int[] price = new int[n + 1];
        int[] weight = new int[n + 1];
        long max = 0;
        for (int i = 1; i < n + 1; i++) {
            weight[i] = scan.nextInt();
            price[i] = scan.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = v; j > 0; j--) {
                int w = j - weight[i];
                if (w >= 0) {
                    dp[j] = Math.max(dp[j], dp[w] + price[i]);
                } else {
                    dp[j] = dp[i];
                }
            }
        }
        for (int i = 0; i < v + 1; i++) {
            max = max > dp[i] ? max : dp[i];
        }
        System.out.println(max);
    }

    /**
     * 给出长度为N的数组，找出这个数组的最长递增子序列。
     * (递增子序列是指，子序列的元素是递增的）
     * 二分查找+动态规划
     * 例如：5 1 6 8 2 4 5 10，最长递增子序列是1 2 4 5 10。
     * 长度对，内容不对  诶：1 3 4 2
     */
    private static void test3() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(num));

        int[] dou = new int[n + 1];
        dou[0] = Integer.MIN_VALUE;
        dou[1] = num[0];
        int Len = 1;
        int p, r, m;
        for (int i = 1; i < n; i++) {
//            使用二分查找，比较当前值num[i]，该放在dou的哪个位置。若num[i]最大，则跟在后面，否则替换相应位置的数据。
            p = 0;
            r = Len;
            while (p <= r) {
                m = (p + r) / 2;
                if (dou[m] < num[i]) {
                    p = m + 1;
                } else {
                    r = m - 1;
                }
            }
            System.out.println(String.format("更新：%d  p:%d", num[i], p));
            dou[p] = num[i];
            if (p > Len) {
                Len++;
            }
            System.out.println(Arrays.toString(dou));
        }
        System.out.println(Len);
        System.out.println(Arrays.toString(dou));

    }

    /**
     * 矩阵取数问题
     * 一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，从左上走到右下，只能向下向右走，求能够获得的最大价值。例如：3 * 3的方格。
     * 1 3 3
     * 2 1 3
     * 2 2 1
     * 能够获得的最大价值为：11。
     * 3
     * 1 3 3
     * [0, 1, 4, 7]
     * 2 1 3
     * [0, 3, 5, 10]
     * 6 2 1
     * [0, 9, 11, 12]
     */
    private static void test2() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] dp = new int[n + 1];
        int[] read = new int[n + 1];
        for (int i = 0; i < n; i++) {
//            接受输入
            for (int j = 1; j < n + 1; j++) {
                read[j] = scan.nextInt();
            }
//            取最大值
            for (int j = 1; j < n + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + read[j];
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(Arrays.toString(dp));
    }

    /**
     * 该三角形第n层有n个数字，例如：
     * 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上
     * 第一层有一个数字：5
     * 第二层有两个数字：8 4
     * 第三层有三个数字：3 6 9
     * 第四层有四个数字：7 2 9 5
     * 最优方案是：5 + 8 + 6 + 9 = 28
     * 注意:上面应该是排列成一个三角形的样子不是竖向对应的，排版问题没有显示成三角形。
     * 状态定义: Fi，j是第i行j列项最大取数和，求第n行Fn，m（0 < m < n）中最大值。
     * 状态转移方程：Fi，j = max{Fi-1,j-1,Fi-1,j}+Ai,jt
     */
    private static void test1() {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long max = 0;
        int[][] dp = new int[n][n + 1];
        dp[0][0] = scan.nextInt();
        System.out.println("1111111");
        for (int i = 1; i < n; i++) {
            //每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。i + 1
            for (int j = 1; j <= i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + scan.nextInt();
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
