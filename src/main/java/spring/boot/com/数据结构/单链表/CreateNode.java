package spring.boot.com.数据结构.单链表;

import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/8/12
 * @description: 创建链表
 */
public class CreateNode {
    private DataNode head;
    public CreateNode(List<Integer> list){
        DataNode head = new DataNode(0);
        DataNode cur = head;
        for(int i=0;i<list.size();i++) {
            DataNode temp = new DataNode(list.get(i));
            cur.setNext(temp);
            cur = temp;
        }
        this.head = head;
    }

    public DataNode getHead() {
        return head;
    }

    public void setHead(DataNode head) {
        this.head = head;
    }
}
