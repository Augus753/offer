package niuke;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static niuke.Solution.*;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/30 9:19
 * @Description SolutionMain
 * <p>
 * 3、test_deleteDuplicates 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * //           例如：
 * //           给出的链表为1 -> 2-> 3-> 3-> 4-> 4->5, 返回1-> 2-> 5.
 * //           给出的链表为1->1 -> 1-> 2 -> 3, 返回2-> 3.
 * <p>
 * 4、test_MLS 给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
 * //           输入 [100,4,200,1,3,2]
 * //           输出 4
 * <p>
 * 6、test_atoi  字符串转数字
 * <p>
 * 7、test_maxsumofSubarray 分治 + 动态规划
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * <p>
 *
 */
public class SolutionMain {
    private Solution solution = new Solution();

    @Test
    public void test_deleteDuplicates() {
        ListNode head = new ListNode();
        ListNode node1 = new ListNode();
        node1.val = 1;
        head.next = node1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node1.next = node2;
        ListNode node21 = new ListNode();
        node21.val = 2;
        node2.next = node21;
//           二叉树层次遍历
        ListNode r = solution.deleteDuplicates(head);
        while (r.next != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    @Test
    public void test_MLS() {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(solution.MLS(arr));
    }


    @Test
    public void test_minNumberdisappered() {
        System.out.println(minNumberdisappered(new int[]{100, 4, 200, 1, 3, 2}));
    }


    @Test
    public void test_atoi() {
        //" -10 0e+21"  越界
        System.out.println(solution.atoi(" 10 0"));
    }

    @Test
    public void test_maxsumofSubarray() {
//        判断当前数与前一个数之和与当前数之间哪个较大，把大的数赋值给当前位置
        System.out.println(solution.maxsumofSubarray(new int[]{1, -2, 3, 5, -2, 6, -1}));
    }




    public static void main(String[] args) {

//        1,2,3,4,5
//        ListNode n5 = new ListNode();
//        n5.val = 5;
//        ListNode n4 = new ListNode();
//        n4.val = 4;
//        n4.next = n5;
//        ListNode n3 = new ListNode();
//        n3.val = 3;
////        n3.next = n4;
//        ListNode n2 = new ListNode();
//        n2.val = 2;
//        n2.next = n3;
//        ListNode head = new ListNode();
//        head.val = 1;
//        head.next = n2;
//        System.out.println(reverseKGroup(head, 2));
//        int[] arr = new int[]{1, 3, 3, 6};
//        System.out.println(maxLength(arr));
//        System.out.println(maxLength2(arr));
        String a = "25525511135";
//        System.out.println(solve(a));
//        System.out.println(restoreIpAddresses(a));
//        System.out.println(Fibonacci(6));
//        System.out.println(LIS(new int[]{1, 2, 8, 6, 4}));
//        给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
//        System.out.println(findShortestSubString1("ADBECEBANC", "ABC"));
//        stringSplit("sskk");
//        链表存在环
//        isExitLoop();
//        int[] arr = new int[]{3, 3, 6, 1, -1};
//        System.out.println(minNumberdisappered(arr));

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int n = 3, num = 0;
//        num += jumpTest(n);
//        for (int i = 1; i <= (n); i++) {
//            num += jumpTest(n);
//        }
//        System.out.println(num);


    }

}
