package spring.boot.com.数据结构.单链表;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/8/12
 * @description: java单链表排序
 * https://blog.csdn.net/zw2008224044/article/details/90713823
 */
public class Sort {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(22, 652, 55, 5, 74, 111, 56);
        DataNode node = new CreateNode(list).getHead();
        System.out.println(sort(node));
    }

    public static DataNode sort(DataNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DataNode pre = head;
        //待排序节点
        DataNode cur = head.next;
        //辅助节点，永远指向头结点
        DataNode aux = new DataNode(0);
        aux.next=head;
        while (cur != null) {
            if (cur.data < pre.data) {
                pre.next = cur.next;
                //从前往后找到node2.val>cur.val,然后把cur节点插入到node1和node2之间
                DataNode node1= aux;
                DataNode node2=aux.next;
                while (cur.data > node2.data) {
                    node1 = node2;
                    node2 = node2.next;
                }
                //把cur节点插入到node1和node2之间
                node1.next=cur;
                cur.next=node2;
                //cur节点向后移动一位
                cur=pre.next;

            }else {
                //向后移动
                pre=cur;
                cur=cur.next;
            }
        }

        return aux.next;
    }

}
