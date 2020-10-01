package niuke;

import java.util.*;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/14 21:20
 * @Description Solution
 */
public class Solution {

    private static void numberGame() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = i;
        }
        StringBuilder result = new StringBuilder();
        int begin = 0;
        int count = 0;
        int totalCount = 0;
        boolean flag = true;
        while (flag) {
            for (int i = begin; i < nArr.length; i++) {
                if (count < m && nArr[i] != -1) {
                    ++count;
                    if (count == m) {
                        count = 0;
                        ++totalCount;
                        nArr[i] = -1;
                        result.append(i + 1);
                        continue;
                    }
                    continue;
                }

                if (count == 0 && nArr[i] != -1) {
                    begin = i;
                }

                if (totalCount == n) {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    /**
     * @param tasks int整型一维数组 待加工的零件
     * @param n     int整型 n的值
     * @return int整型
     */
    public int leastWorkTime(int[] tasks, int n, int idx) {
        // write code here
        int num = 0;
        boolean flag = true;
        if (idx >= tasks.length - 1) {
            idx = 0;
        }
        tasks[idx] = -1;
        for (int j = 0; j < Math.min(10, idx); j++) {
            tasks[idx - j] = 0;
        }

        for (int i = idx; idx < tasks.length; i++) {
            if (tasks[i] > 0) {
                for (int j = 0; j < Math.min(10, i); j++) {
                    tasks[i - j] = 0;
                }
            }
            tasks[i] = -1;
        }
        return 1 + leastWorkTime(tasks, n, idx++);
    }

    private static int jumpTest(int n) {
        if (n < 1) {
            return 0;
        }
        return 1 + 2 * jumpTest(n - 1);
    }

    private static void test111() {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        StringBuilder data = new StringBuilder();
        while (group-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] str = new int[n];
            for (int i = 0; i < str.length; i++) {
                str[i] = sc.nextInt();
            }
            Random random = new Random();
            int[] line = new int[m];
            for (int i = 0; i < m; i++) {
                line[i] = str[random.nextInt(n)];
            }
            System.out.println(Arrays.toString(line));
            String result = "YES";
            for (int i = 0; i < line.length; i++) {
                int a = line[i];
                for (int j = i; j < line.length; j++) {
                    int b = line[i];
                    if ((a + b) % k != 0) {
                        result = "NO";
                    }
                }
            }
            data.append(result).append("\n");
        }
        System.out.println(data);

    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> path = new ArrayList();
        if (root == null) return res;
        dfs(root, 0, sum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int nowsum, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        //判断是否为叶子节点，当前nowsum是否与sum相等，
        if (root.left == null && root.right == null && sum == (nowsum + root.val)) {
            //相等就将list加入到结果中，
            res.add(new ArrayList(list));
            return;
        }
        if (root.left != null) {
            dfs(root.left, nowsum + root.val, root.val, list, res);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, nowsum + root.val, root.val, list, res);
            list.remove(list.size() - 1);
        }
    }

    //巧妙
    public static int minNumberdisappered(int[] arr) {
        // write code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //把各个值作为索引使用交换的形式放入到原数组中。使数组有序，第一个空出的值即为目标结果
            while (arr[i] > 0 && arr[i] < n && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * 链表存在环
     *
     * @param node
     * @return
     */
    private static boolean isExitLoop(ListNode node) {
        //指向第一个
        ListNode p = node;
        //指向第二个
        ListNode q = node.next;
        while (p != q && p != null && q != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }

    /**
     * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // write code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    private static void stringSplit(String str) {
        List<String> result = new ArrayList();
        char[] strArr = str.toCharArray();
        int s1 = 0, s2 = 0, s3 = 0;
        boolean switchStr = false, finish = false;
        char startA = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            if (finish) {
                //新的一次，重新计算
                switchStr = false;
                finish = false;
                startA = strArr[i];
                s1 = i;
            }
            //改变前后字符的情况
            if (startA != strArr[i]) {
                //
                if (switchStr) {
                    s1 = s2 - (s3 - s2);
                    finish = true;
                } else {
                    s2 = i;
                    switchStr = true;
                }
            } else {
                //进入到后一个字符的判断
                s3 = i;
            }

            if (finish) {
                //
                result.add(str.substring(s1, s3));
            }
        }
    }

    /**
     * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
     * 输入: S = “ADOBECODEBANC”, T = “ABC”
     * 输出: “BANC”
     * 如果 S 中不存这样的子串，则返回空字符串 “”。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     * @param s
     * @param t
     * @return
     */
    private static String findShortestSubString1(String s, String t) {
        String tLow = t.toLowerCase();
        String sLow = s.toLowerCase();
        int[] dp = new int[257];//字符：保存待查找的内容，转化为ASCALL码
        for (int i = 0; i < tLow.length(); i++) {
//            tLow里字符对应的dp位置的数据为 1
            dp[tLow.charAt(i)]++;
        }
        System.out.println(Arrays.toString(dp));
        int begin = 0, end = 0;
        int minBegin = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        while (end < sLow.length()) {
            if (dp[sLow.charAt(end)] > 0) {
                count++;            // 如示例，只有匹配到第一个a时count才会加1，之后的dp[a]<=0,即不再是匹配T所必需的字符了（以为已经有一个了）
            }
            dp[sLow.charAt(end)]--;  //窗口中的每个字符都要减一
            end++;
            while (count == t.length()) {//子串的字符都已经出现，检测
                if (end - begin < minLength) {
                    minLength = end - begin;
                    minBegin = begin;
                }
                if (dp[sLow.charAt(begin)] == 0) {
                    count--;
                }
                dp[sLow.charAt(begin)]++;
                begin++;

            }
        }
        if (minLength != Integer.MAX_VALUE) {
            return (s.substring(minBegin, minBegin + minLength));
        } else {
            return ("没找到唉");
        }
    }

    /**
     * 合并两个有序数组
     * 从后往前处理,不需要开辟额外空间
     *
     * @param A
     * @param m A初始的元素数目分别为
     * @param B
     * @param n B初始的元素数目分别为
     */
    public void mergeArr(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1;
    }

    private int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public static String solve(String str) {
        // write code here
        char[] strArr = str.toCharArray();
        int start = 0, end = strArr.length - 1;
        while (start < end) {
            char temp = strArr[end];
            strArr[end] = strArr[start];
            strArr[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(strArr);
    }


    /**
     * 有重复数字的有序数组的二分查找
     *
     * @param n
     * @param v
     * @param a
     * @return
     */
    public static int upper_bound_(int n, int v, int[] a) {
        // write code here
        if (v > a[n - 1]) return n + 1;
        int startIdx = 0, endIdx = n - 1;
        while (startIdx < endIdx) {
            int checkIdx = startIdx + (endIdx - startIdx) / 2;
            if (v > a[checkIdx]) {
                startIdx = checkIdx + 1;
            } else {
                endIdx = checkIdx;
            }
        }
        return startIdx + 1;
    }

    /**
     * 字符串转化为IP地址
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public static ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> result = new ArrayList();
        DFSIp(result, "", s, 0);
        return result;
    }

    private static void DFSIp(ArrayList<String> result, String lStr, String rStr, int count) {
        if (count == 3 && isValid(rStr)) {
            result.add(lStr + rStr);
            return;
        }
        for (int i = 1; i < 4 && i < rStr.length(); i++) {
            String ipSub = rStr.substring(0, i);
            if (isValid(ipSub)) {
                DFSIp(result, lStr + ipSub + '.', rStr.substring(i), count + 1);
            }
        }
    }

    private static boolean isValid(String str) {
        if (str.length() <= 0 || str.length() > 3) {
            return false;
        }
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(str);
        return num <= 255 && num >= 0;
    }

    public static int Fibonacci(int n) {
        int[] vul = new int[]{0, 1};
        if (n < 2) {
            return vul[n];
        }
        int c = vul[0] + vul[1];
        for (int i = 2; i < n; i++) {
            vul[0] = vul[1];
            vul[1] = c;
            c = vul[0] + vul[1];
        }
        return c;

//        int f = 0,g=1;
//        for(int i=0;i<n;i++){
//            g += f;
//            f = g-f;
//        }
    }


    private static void test4() {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();
        for (int i = 0; i < 2 * N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            x = logVul(x, A);
        }
    }

    private static int logVul(int x, int xVul) {
        int s = (int) ((Math.log(x) / Math.log(2)) * 1);
        return 0;
    }

    private static void test3() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String nStr = sc.next();
        char[] nArr = nStr.toCharArray();
        char[] mStr = sc.next().toCharArray();
        Map<Character, Integer> data = new HashMap();
        for (int i = 0; i < N; i++) {
            if (!data.containsKey(nArr[i])) {
                data.put(nArr[i], i + 1);
            }
        }
        int maxIdx = 0, sumIdx = 0;
        for (int i = 0; i < M; i++) {
            char mArr = mStr[i];
            Integer cacheIdx = data.get(mArr);
            if (cacheIdx == null) {
                System.out.println("NO");
                return;
            }
            if (maxIdx > cacheIdx) {
                System.out.println("NO");
                return;
            }
            maxIdx = cacheIdx;
            sumIdx += maxIdx;
        }
        System.out.println("Yes");
        System.out.println(sumIdx);
    }

    private static void test2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        String[][] content = new String[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = sc.next().toCharArray();
            for (int j = 0; j < line.length; j++) {
                content[i][j] = String.valueOf(line[j]);
//            }
            }
//            System.out.println("输入：" + Arrays.toString(content[i]));
        }
        String path = sc.next();
        char[] pathArr = path.toCharArray();
        int i = 0, j = 0, score = 0;
        for (char pathA : pathArr) {
//            System.out.println(String.format("i:%d j:%d pathA:%s", i, j, pathA));
            switch (pathA) {
                case 'W':
                    if (i >= 0 && !content[i - 1][j].equals("#")) {
                        i--;
                    }
                    break;
                case 'A':
                    if (j >= 0 && !content[i][j - 1].equals("#")) {
                        j--;
                    }
                    break;
                case 'S':
                    if (i < N - 1 && !content[i + 1][j].equals("#")) {
                        i++;
                    }
                    break;
                case 'D':
                    if (j < M - 1 && !content[i][j + 1].equals("#")) {
                        j++;
                    }
                    break;
            }
//            System.out.println(String.format("i:%d j:%d  %s", i, j, content[i][j]));
            if ("O".equals(content[i][j])) {
                score += P;
            } else if ("X".equals(content[i][j])) {
                score -= Q;
            }
            if (!"#".equals(content[i][j])) {
                content[i][j] = "+";
            }
        }
        System.out.println(score);
    }


    private static void test1() {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] iArr = new int[6];
        int count = 0;
        for (int i = M; i <= N; i++) {
            intToArr(iArr, i);
            if (check(iArr)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(int[] iArr) {
        for (int i = 0; i < iArr.length - 1; i++) {
            for (int j = i + 1; j < iArr.length; j++) {
                if (iArr[i] == iArr[j]) {
                    return false;
                }
            }
        }
        return iArr[0] * 10 + iArr[2] + iArr[2] * 10 + iArr[3] == iArr[4] * 10 + iArr[5];
    }

    private static void intToArr(int[] iArr, int vul) {
        int temp = vul;
        for (int i = iArr.length - 1; i >= 0; i--) {
            temp = temp % 10;
            iArr[i] = temp;
        }
    }

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode cur = head;
        ListNode result = new ListNode();
        result.next = head;
        ListNode pre = result;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return result.next;
    }

    /**
     * max increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int MLS(int[] arr) {
        // wrilte code here
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int count = 1, maxCount = 1;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == 1) {
                count++;
            } else if (diff > 0) {
                count = 1;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }


    public int atoi(String str) {
        // write code here
        if (str == null || "".equals(str)) return 0;

        char[] chars = str.toCharArray();
        boolean negative = false;
        int digit = 0;
        for (char s : chars) {
            // 1. 空字符和正号
            if (s == ' ' || s == '+') continue;
            //2、记录负号
            if (s == '-') {
                negative = true;
            } else if (Character.isDigit(s)) {
                //3、判断数字字符
//                4、处理越界
                if (digit > Integer.MAX_VALUE / 10 || digit == Integer.MAX_VALUE / 10 && s - '7' > 0) {
                    if (!negative)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                digit = digit * 10 + Integer.parseInt(s + "");
            } else {
                //5、其他字符
                break;
            }
        }
        return negative ? -digit : digit;
    }

    /**
     * 分治法
     * 判断当前数与前一个数之和与当前数之间哪个较大，把大的数赋值给当前位置，遍历一遍之后最大累计和就在容器末尾，以此分而治之，分治法解该题非常合适。
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        // write code here
        for (int i = 1; i < arr.length; i++) {
//            判断当前数与前一个数之和与当前数之间哪个较大，把大的数赋值给当前位置
            arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
        }
        return arr[arr.length - 1];
    }


}
