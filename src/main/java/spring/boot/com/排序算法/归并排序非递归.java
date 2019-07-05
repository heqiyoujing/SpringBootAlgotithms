package spring.boot.com.排序算法;

import static spring.boot.com.排序算法.归并排序.merge;

/**
 * @author: yiqq
 * @date: 2019/6/4
 * @description:
 */
public class 归并排序非递归 {
    public static void main(String[] args) {
        int[] num = {64,55,3,266,232,66,44};
        mergeSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
    // 非递归式的归并排序
    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        // 子数组的大小分别为1，2，4，8...
        // 刚开始合并的数组大小是1，接着是2，接着4....
        for (int i = 1; i < n; i += i) {
            //进行数组进行划分
            int left = 0;
            int mid = left + i - 1;
            int right = mid + i;
            //进行合并，对数组大小为 i 的数组进行两两合并
            while (right < n) {
                // 合并函数和递归式的合并函数一样
                merge(arr, left, mid, right);
                left = right + 1;
                mid = left + i - 1;
                right = mid + i;
            }
            // 还有一些被遗漏的数组没合并，千万别忘了
            // 因为不可能每个字数组的大小都刚好为 i
            if (left < n && mid < n) {
                merge(arr, left, mid, n - 1);
            }
        }
        return arr;
    }
}
