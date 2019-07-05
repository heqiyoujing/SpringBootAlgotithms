package spring.boot.com.排序算法;


/**
 * @author: yiqq
 * @date: 2019/5/31
 * @description:
 */
public class 插入排序 {
    /** 性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序*/
    public static void main(String[] args) {
        int[] num = {64,55,3,266,232,66,44};
        insertSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return arr;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > temp){
                arr[k + 1] = arr[k];
                k--;
            }
            //插进去
            arr[k + 1] = temp;
        }
        return arr;
    }

}
