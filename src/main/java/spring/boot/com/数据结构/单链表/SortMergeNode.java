package spring.boot.com.数据结构.单链表;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/8/12
 * @description: 链表的归并排序
 */
public class SortMergeNode {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(22, 652, 55, 5, 74, 111, 56);
        DataNode node = new CreateNode(list).getHead();
        sortList(node);
    }

    public static DataNode sortList(DataNode head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        DataNode mid = getMid(head);
        DataNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortList(head), sortList(right));
    }

    private static DataNode getMid(DataNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        DataNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private static DataNode mergeSort(DataNode head1, DataNode head2) {
        DataNode p1 = head1, p2 = head2, head;
        //得到头节点的指向
        if (head1.data < head2.data) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        DataNode p = head;
        //比较链表中的值
        while (p1 != null && p2 != null) {

            if (p1.data <= p2.data) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        //第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        //第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
}
