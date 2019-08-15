package spring.boot.com.数据结构.单链表;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/8/14
 * @description: 链表对折
 * https://www.cnblogs.com/hiyashinsu/p/10583804.html
 */
public class Solution {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(22, 652, 55, 5, 74, 111, 56,686,43,23,1111);
        List<Integer> list = Arrays.asList(22, 652, 55, 5, 74, 111, 56,686);
        DataNode node = new CreateNode(list).getHead();
        reorderList(node);
        DataNode dataNode = node;
        while (dataNode.next != null) {
            System.out.println(dataNode.data);
            dataNode = dataNode.next;
        }
    }
    public static void reorderList(DataNode head) {
        //获取后半段节点
        DataNode p1 = head;
        DataNode p2 = head;
        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p1 != null) {
            p2 = p1.next;
            p1.next = null;
        }
        DataNode pre = reverseList(p2);//链表反转
        mergeLists(head, pre);
    }
    /**链表反转*/
    public static DataNode reverseList(DataNode p) {
        if (p == null)
            return p;
        DataNode pre = p;
        p = p.next;
        pre.next = null;
        while (p != null) {
            DataNode tmp = p;
            p = p.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }

    /**合并链表*/
    public static void mergeLists(DataNode head, DataNode pre) {
        DataNode p1 = head;
        DataNode p2 = pre;
        DataNode tmp = null;
        while (p1 != null && p2 != null) {
            tmp = p1.next;
            p1.next = p2;
            p1 = tmp;
            if (p1 == null) {
                break;
            }
            tmp = p2.next;
            p2.next = p1;
            p2 = tmp;
        }
    }
}
