package spring.boot.com.排序算法;

/**
 * @author: yiqq
 * @date: 2019/6/3
 * @description:
 */
public class 冒泡排序优化 {
    public static void main(String[] args) {
        int[] num = {64,65,67,66,68,69,70};
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
            boolean flag = true;
            for (int j = 0; j < n -i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = false;
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
            //一趟下来是否发生位置交换
            if(flag)
                break;
        }
        return arr;
    }

}
