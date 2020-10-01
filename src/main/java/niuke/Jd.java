package niuke;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/17 19:53
 * @Description Jd
 */
public class Jd {

    public static void main(String[] args) {
//        test1();
//        System.out.println(fun(10,0));
        String s = "23443ab549abe";
//        Pattern p = Pattern.compile("[0-9a-z]{2}(?=ab)");
//        System.out.println(s.matches("[0-9a-z]{2}(?=ab)"));
        System.out.println(Math.log(1000)/Math.log(2));
    }

    private static int fun(int x, int i) {
        System.out.println("aaaaaa");
        if (x <= 2) return 1;
        return fun(x - 2, i) + fun(x - 4, i) + 1;
    }

    static void os() {
        System.out.println("os");
    }

    private static String test2() {
//        int n = 2, m = 2;
//        String[][] grid = new String[n][m];
//        grid[0][0] = ".";
//        grid[0][1] = "E";
//        grid[1][0] = "S";
//        grid[1][1] = "#";
        Scanner scan = new Scanner(System.in);
        int group = scan.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < group; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            String[][] grid = new String[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    grid[j][k] = scan.next();
                }
            }
            result.append(check(grid)).append("\n");
        }
        return result.toString();
    }

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    private static String check(String[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] status = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[0][i].equals("#")) {
                status[0][i] = 0;
                break;
            } else status[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0].equals("#")) {
                status[i][0] = 0;
                break;
            } else status[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j].equals("#")) status[i][j] = 0; // 注意这里判断的是原数组 不是dp[]
                else
                    status[i][j] = status[i - 1][j] + status[i][j - 1];
            }
        }
        return (status[n - 1][m - 1] > 0) ? "YES" : "NO";
    }

    private static void test1() {
        Scanner scanner = new Scanner(System.in);
//        String input = "And millionaires will hold 46% of total wealth bye 201003abc 2020 , the report says. This ratio is likely to increase in 2020.\n";
//        String input=scanner.nextLine();
        String input = "23443ab549abe";
        System.out.println("str：  " + input);
        Pattern p = Pattern.compile("[0-9a-z]{2}(?=ab)");

//        Pattern p = Pattern.compile("\\D[1|2|3][\\d]{3}\\D");
        Matcher m = p.matcher(input);
        StringBuilder result = new StringBuilder();
        while (m.find()) {
            String str = m.group();
            result.append(str, 1, str.length() - 1).append(" ");
        }
        if (result.length() > 1) result.delete(result.length() - 1, result.length());
        System.out.println(result);
    }
}
