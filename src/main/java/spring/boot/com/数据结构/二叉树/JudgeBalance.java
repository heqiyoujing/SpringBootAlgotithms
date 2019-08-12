package spring.boot.com.数据结构.二叉树;

/**
 * @author: yiqq
 * @date: 2019/8/8
 * @description: 判断是否是平衡二叉树
 */
public class JudgeBalance {
    private static boolean isBalanced = false;//最后的返回值

    public static void main(String[] args) {
        int[] array={12,11,4,7,34,23,56,43,22,11,55,6};
        BinaryTree root = new BinaryTree(array[0]);
        for(int i=1;i<array.length;i++) {
            root.insert(root, array[i]);
        }
        System.out.println(IsBalanced_Solution(root));

    }

    public static boolean IsBalanced_Solution(BinaryTree root) {
        getDepth(root);
        return isBalanced;
    }
    public static int getDepth(BinaryTree root) {
        if(root == null) {
            isBalanced = true;
            return 0;
        }
        int left = getDepth(root.left);//左子树
        int right = getDepth(root.right);//右子树
        int depth = (left > right ? left : right) + 1;
        if(Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }
        return depth;//下层的深度，上层可以接着用免得再遍历
    }

}
