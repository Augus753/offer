package niuke;

import org.junit.jupiter.api.Test;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/30 22:48
 * @Description ListNodeSolutionMain
 * 1、test_mergeTwoLists  有序的链表合并
 * 2、removeNthFromEnd 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 3、detectCycle 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 4、 addInList 加法
 * //   输入 [9,3,7],[6,3]
 * //   输出 {1,0,0,0}
 * 5、test_reverseKGroup 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * //          如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * //          例如：
 * //          给定的链表是1-> 2-> 3-> 4-> 5
 * //          对于 k=2, 你应该返回 2->  1->  4->  3->  5
 * //          对于 k=3, 你应该返回 3-> 2 -> 1 ->  4->  5
 * 6、ReverseList   链表反转
 * 7、reverse   给定范围内的链表反转
 * <p>
 * 8、test_sortInList   链表选择排序（每次选出最小的放在前面）
 * <p>
 * 9、test_FindFirstCommonNode   输入两个链表，找出它们的第一个公共结点
 */
public class ListNodeSolutionMain {
    private ListNodeSolution solution = new ListNodeSolution();
    private ListNode head = new ListNode();

    private void getHead() {
        ListNode n5 = new ListNode();
        n5.val = 5;
        ListNode n4 = new ListNode();
        n4.val = 4;
        n4.next = n5;
        ListNode n3 = new ListNode();
        n3.val = 3;
        n3.next = n4;
        ListNode n2 = new ListNode();
        n2.val = 2;
        n2.next = n3;
        head.val = 1;
        head.next = n2;
    }

    @Test
    public void test_mergeTwoLists() {
        ListNode pHead1 = new ListNode();
        ListNode pHead2 = new ListNode();
        System.out.println(solution.mergeTwoLists(pHead1, pHead2));
    }

    @Test
    public void test_reverseKGroup() {
        //        1,2,3,4,5
        getHead();
        ListNode r = solution.reverseKGroup(head, 2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    @Test
    public void test_sortInList() {
        //        1,2,3,4,5
        getHead();
        ListNode r = solution.sortInList(head);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    @Test
    public void test_FindFirstCommonNode() {
        ListNode pHead1 = new ListNode();
        ListNode pHead2 = new ListNode();
        System.out.println(solution.FindFirstCommonNode(pHead1, pHead2));
    }


}
