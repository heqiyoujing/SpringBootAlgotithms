package spring.boot.com.数据结构.单链表;

/**
 * @author: yiqq
 * @date: 2019/7/16
 * @description:
 */
public class DataNodeTest {
    public static void main(String[] args) {
        DataChain chain = new DataChain(10);
        DataNode node = reverse1(chain.getHead());
        DataChain.printChain(node);
    }

    /**
     * 通过遍历实现
     * @param node
     * @return
     */
    public static DataNode reverse(DataNode node){
        //如何链表没有元素或者链表只有一个元素，不必要反转，返回链表本身就行。
        if(node == null ||node.next == null){
            return node;
        }

        //当链表超过两个及以上就需要反转
        DataNode pre = null;//用于保存当前节点的前一个节点
        DataNode cur = node;//cur保存当前节点

        while(cur != null){
            DataNode next = cur.next;//获取当前节点的下一个元素
            cur.next = pre;//把当前节点的next指向前一个元素
            pre = cur;//把当前节点改为前一个节点（其实就是前一个元素后移一位）。
            cur = next;//把当前节点的下一个节点改为当前节点（其实就是前一个元素后移一位）。
        }

        //因为反转后pre是第一个节点，所以返回pre.
        return pre;
    }

    /**
     * 通过递归实现
     * @param head
     * @return
     */
    public static DataNode reverse1(DataNode head) {
        if (null == head || null == head.getNext())
            return head;
        DataNode revHead = reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return revHead;
    }
}
