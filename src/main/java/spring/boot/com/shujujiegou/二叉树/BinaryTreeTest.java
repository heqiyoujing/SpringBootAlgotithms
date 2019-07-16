package spring.boot.com.shujujiegou.二叉树;

/**
 * @author: yiqq
 * @date: 2019/7/16
 * @description:
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
        System.out.println("----------中序遍历");
        inOrder(root);
        System.out.println("----------后序遍历");
        postOrder(root);
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
}
