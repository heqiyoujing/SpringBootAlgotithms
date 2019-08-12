package spring.boot.com.数据结构.二叉树;

import java.util.Stack;

/**
 * @author: yiqq
 * @date: 2019/7/16
 * @description:
 * https://www.jianshu.com/p/8efe8f281f22（Java 实现的二叉树的递归、非递归遍历）
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        int[] array={12,11,4,7,34,23,56,43,22,11,55,6};
        BinaryTree root = new BinaryTree(array[0]);
        for(int i=1;i<array.length;i++) {
            root.insert(root, array[i]);
        }
        System.out.println("----------前序遍历");
        preOrder(root);
//        System.out.println("----------中序遍历");
//        inOrder(root);
//        System.out.println("----------后序遍历");
//        postOrder(root);
        System.out.println("----------前序遍历非递归");
        preOrderFei(root);
    }

    //前序遍历
    private static void preOrder(BinaryTree root) {
        if (root != null) {
            System.out.println("data： " + root.data);
            preOrder(root.left);
            preOrder(root.right);

        }
    }

    //中序遍历
    private static void inOrder(BinaryTree root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("data： " + root.data);
            inOrder(root.right);
        }
    }

    //后序遍历
    private static void postOrder(BinaryTree root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("data： " + root.data);
        }
    }

    //非递归前序遍历
    public static void preOrderFei(BinaryTree head) {
        if (head == null) {
            return;
        }
        Stack<BinaryTree> s = new Stack<BinaryTree>();
        s.push(head);
        while (!s.isEmpty()) {
            BinaryTree cur = s.pop();
            System.out.println(cur.data);
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
    }
}
