package niuke;

import java.util.Stack;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/30 22:45
 * @Description ListNodeSolution
 * 链表
 */
public class ListNodeSolution {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode resNode = new ListNode();
        ListNode cur = resNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return resNode.next;
    }

    /**
     * NC53:removeNthFromEnd给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode cur = head;
        while (cur != null && n-- >= 0) {
            System.out.print("aaaaa");
            cur = cur.next;
            if (n == 0 && cur != null) {
                cur = cur.next;
            }
        }
        return head.next;
    }

    /**
     * NC3:detectCycle 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    //slow——》2slow
                    //fast——》slow
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * addInList 加法
     * 输入 [9,3,7],[6,3]
     * 输出 {1,0,0,0}
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }
        ListNode header = null;
        int ca = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int z = x + y + ca;
            // 头插法
            ListNode node = new ListNode();
            node.val = z % 10;
            node.next = header;
            header = node;
            ca = z / 10;
        }
        if (ca == 1) {
            ListNode node = new ListNode();
            node.val = 1;
            node.next = header;
            header = node;
        }
        return header;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = ReverseList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public void reverse(ListNode start, ListNode end) {
        ListNode cur = start, pre = end.next;
        while (pre != end) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
    }

    /**
     * reverseKGroup
     * 题目描述
     * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     * 要求空间复杂度  O(1)
     * 例如：
     * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
     * 对于 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
     * 对于 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, cur = head, temp;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                //把cur节点给temp
                temp = cur.next;
                cur.next = temp.next;
                //temp插入到pre，作为下一个节点
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        ListNode cur = head, minNode;
        while (cur != null) {
            minNode = cur;
            ListNode next = cur.next;
            //找出最小值
            while (next != null) {
                if (next.val < minNode.val) {
                    minNode = next;
                }
                next = next.next;
            }
            //插入
            int minVul = minNode.val;
            minNode.val = cur.val;
            cur.val = minVul;
            cur = cur.next;
        }
        return head;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p = pHead1;
        ListNode q = pHead2;
        while (p != q) {
            p = p == null ? pHead2 : p.next;
            q = q == null ? pHead1 : q.next;
        }
        return p;
    }
}
