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

    /**
     Binary Search Tree(BSTree)二叉查找树
     在二叉查找树中：
     (01) 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     (02) 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     (03) 任意节点的左、右子树也分别为二叉查找树。
     (04) 没有键值相等的节点（no duplicate nodes）。
     */
}
