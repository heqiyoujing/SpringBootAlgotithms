package spring.boot.com.排序算法;

/**
 * @author: yiqq
 * @date: 2019/6/3
 * @description: https://zhuanlan.zhihu.com/p/57088609?utm_source=wechat_session&utm_medium=social&s_r=0#showWechatShareTip
 */
public class 冒泡排序 {
    /**性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序*/
    public static void main(String[] args) {
        int[] num = {64,55,3,266,232,66,44};
        bubbleSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        return arr;
    }
}
