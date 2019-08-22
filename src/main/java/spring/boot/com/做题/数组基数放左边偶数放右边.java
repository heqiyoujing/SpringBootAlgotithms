package spring.boot.com.做题;

/**
 * @author: yiqq
 * @date: 2019/8/22
 * @description: 将一个数组的基数放在左边，偶数放在右边
 */
public class 数组基数放左边偶数放右边 {
    public static void main(String[] args) {
        int[] arr = {48, 67, 78, 33, 55, 6, 89, 666, 999, 888};
        sortLeftAndRight(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+"  ");
        }
    }

    public static void sortLeftAndRight(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            while (arr[i] % 2 == 1) {
                i++;
            }
            while (arr[j] % 2 == 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
