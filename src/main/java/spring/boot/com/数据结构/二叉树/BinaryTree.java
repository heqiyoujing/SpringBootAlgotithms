package spring.boot.com.数据结构.二叉树;

/**
 * @author: yiqq
 * @date: 2019/7/16
 * @description: 二叉树的前序、中序、后序遍历Java实现
 * https://blog.csdn.net/li_jian_fei/article/details/77069489
 */
public class BinaryTree {
    int data;//根节点数据
    BinaryTree left;//左子树
    BinaryTree right;//左子树

    public BinaryTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(BinaryTree root, int data) {
        if (data > root.data) { // 右子节点
            if (root.right == null) {
                root.right = new BinaryTree(data);
            }else {
                insert(root.right, data);
            }
        }else {
            if (root.left == null) {
                root.left = new BinaryTree(data);
            }else {
                insert(root.left, data);
            }
        }
    }
}
